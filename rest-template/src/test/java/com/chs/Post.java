package com.chs;

import com.alibaba.fastjson.JSONObject;
import com.chs.entity.Comment;
import com.chs.repository.CommentRepository;
import com.chs.util.CsvUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author : HongSheng.Chen
 * @date : 2020/4/17 18:47
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})// 指定启动类
public class Post {


    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void post() {
        List<String[]> datas = CsvUtil.getDataList("d:/test.csv");

        HttpHeaders httpHeaders = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json;charset=UTF-8");
        httpHeaders.setContentType(type);

        String url = "";

        for (int i = 1; i < datas.size(); i++) {
            String[] data = datas.get(i);

            String gameId = data[0];
            Integer score = Integer.valueOf(data[1]);
            String commenta = data[2];
            String commentb = data[3];
            String commentc = data[4];
            String commentd = data[5];
            String commente = data[6];


            Map<String, Object> params = new HashMap<>();
            params.put("moduleType", "GAME");
            params.put("resourceId", gameId);

            params.put("commentId", "5e99722c92fa520001d4889f");

            Comment comment = new Comment();
            comment.setId(UUID.randomUUID().toString());
            comment.setScore(score);
            comment.setGameId(gameId);
            comment.setComment(commenta);
            comment.setCommentb(commentb);
            comment.setCommentc(commentc);
            comment.setCommentd(commentd);
            comment.setComment(commente);
            comment.setCreateTime(111111111L);
            commentRepository.save(comment);

//            HttpEntity<Map<String, Object>> objectHttpEntity = new HttpEntity<>(params, httpHeaders);
//            JSONObject result = restTemplate.postForObject(url, objectHttpEntity, JSONObject.class);
//            System.out.println(result);

        }

    }


}
