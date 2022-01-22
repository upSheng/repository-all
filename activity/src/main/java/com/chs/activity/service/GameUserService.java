package com.chs.activity.service;

import com.chs.activity.dao.GameMapper;
import com.chs.activity.dao.GameUserMapper;
import com.chs.activity.modal.entity.GameEntity;
import com.chs.activity.modal.entity.GameUserEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameUserService {

    @Resource
    GameUserMapper gameUserMapper;

    @Resource
    GameMapper gameMapper;

    public List<GameEntity> getGameByPhone(String phone){
        List<GameUserEntity> gameUserEntityList = gameUserMapper.findByPhone(phone);
        if (CollectionUtils.isEmpty(gameUserEntityList)){
            return Collections.emptyList();
        }
        List<Integer> gameIdList = gameUserEntityList.stream().map(x -> x.getGameId()).collect(Collectors.toList());
        return gameMapper.findByIdList(gameIdList);

    }
}
