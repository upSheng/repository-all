package com.chs.activity.service;

import com.alibaba.fastjson.JSON;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.chs.activity.base.response.EasyPage;
import com.chs.activity.dao.GameMapper;
import com.chs.activity.modal.bean.GameQuery;
import com.chs.activity.modal.bean.heybox.GameInfo;
import com.chs.activity.modal.bean.heybox.GameInfoRes;
import com.chs.activity.modal.entity.GameEntity;
import com.chs.activity.modal.vo.GameVO;
import com.chs.activity.utils.HttpUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


/**
 * @author : HongSheng.Chen
 * @date : 2021/4/1 10:15
 */
@Service
public class GameService {


    @Resource
    GameMapper gameMapper;

    @Value("${oss.accessKeyId}")
    private String accessKeyId;

    @Value("${oss.accessKeySecret}")
    private String accessKeySecret;

    private String heihePrefix = "https://api.xiaoheihe.cn/game/web/get_game_detail/?appid=";

    public EasyPage<GameVO> search(GameQuery gameQuery) {

        PageHelper.startPage(gameQuery.getPageNum(), gameQuery.getPageSize());
        List<GameEntity> gameEntityList = gameMapper.list(gameQuery);
        if (CollectionUtils.isEmpty(gameEntityList)) {
            return new EasyPage<>(null, 0L);
        }
        PageInfo pageInfo = new PageInfo(gameEntityList);
        List<GameEntity> list = pageInfo.getList();
        List<GameVO> gameVOList = list.stream().map(x -> GameVO.builder()
                .id(x.getId())
                .name(x.getName())
                .nameEn(x.getNameEn())
                .appId(x.getAppId())
                .price(x.getPrice())
                .oriPrice(x.getOriPrice())
                .steamImg(x.getSteamImg())
                .steamUrl(x.getSteamUrl())
                .gameInfo(JSON.parseObject(x.getInfo(),GameInfo.class))
                .build()).collect(Collectors.toList());
        return new EasyPage<>(gameVOList, pageInfo.getTotal());
    }


    public GameEntity save(GameEntity gameEntity) {
        if (gameEntity.getId() == null) {

            String appId = gameEntity.getAppId();
            if (appId != null) {
                String str = HttpUtils.get(heihePrefix + appId);
                GameInfoRes gameInfoRes = JSON.parseObject(str, GameInfoRes.class);
                GameInfo gameInfo = gameInfoRes.getResult();


                gameEntity.setName(gameInfo.getName());
                gameEntity.setNameEn(gameInfo.getName_en());
                gameEntity.setSteamImg(getHeadImg(appId));
                gameEntity.setSteamUrl(getSteamUrl(appId));
                gameEntity.setInfo(JSON.toJSONString(gameInfo));

                gameEntity.setWeight(0);
                gameEntity.setOriPrice(gameInfo.getHeybox_price().getOriginal_coin()/10);
                gameEntity.setExe(UUID.randomUUID().toString().replaceAll("-",""));


            }
            gameEntity.setCreateTime(LocalDateTime.now());
            gameEntity.setUpdateTime(LocalDateTime.now());
            gameMapper.insert(gameEntity);
        }else {
            gameEntity.setUpdateTime(LocalDateTime.now());
            gameMapper.update(gameEntity);
        }




        return gameEntity;
    }

    public EasyPage<GameEntity> list(GameQuery gameQuery) {
        PageHelper.startPage(gameQuery.getPageNum(), gameQuery.getPageSize());
        List<GameEntity> gameEntityList = gameMapper.list(gameQuery);
        if (!CollectionUtils.isEmpty(gameEntityList)){
            gameEntityList.stream().forEach(x-> x.setGameInfo(JSON.parseObject(x.getInfo(),GameInfo.class)));
        }
        PageInfo pageInfo = new PageInfo(gameEntityList);
        return new EasyPage<>(pageInfo.getList(), pageInfo.getTotal());
    }

    public void delete(Integer id) {
        gameMapper.deleteById(id);
    }


    public String upload(MultipartFile file) {

        String endpoint = "https://oss-cn-beijing.aliyuncs.com";
        String bucketName = "steamhy";
        String objectName = "abc/"+file.getOriginalFilename();
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        String url = "";
        try {
            ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(file.getBytes()));
            ossClient.shutdown();
            url = ossClient.generatePresignedUrl(bucketName, objectName, new Date(System.currentTimeMillis()+1000L*60*60)).toString();
            System.out.println(url);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return url;

    }

    private String getHeadImg(String appId) {

        return "https://media.st.dl.pinyuncloud.com/steam/apps/" + appId + "/header.jpg";
    }

    private String getSteamUrl(String appId) {
        return "https://store.steampowered.com/app/" + appId;

    }

}
