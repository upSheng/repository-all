package com.chs.element;

import com.alibaba.fastjson.JSONObject;
import com.chs.entity.Comment;
import com.chs.repository.CommentRepository;
import com.chs.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

@Component
public class CommentHelp {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpHeaders httpHeaders;

    @Autowired
    private CommentRepository commentRepository;


    private static final String commentUrl = "http://localhost:8080/comment";
    private static final String replyUrl = "http://localhost:8080/comment";

    /**
     * 评论
     *
     * @param params
     * @return
     */
    public JSONObject comment(Map<String, String> params, Long start, Long end) {


        Long createTime = DateUtil.random(start, end);
        params.put("createTime", createTime.toString());
        HttpEntity<Map<String, Object>> objectHttpEntity = new HttpEntity(params, httpHeaders);
        JSONObject result = restTemplate.postForObject(commentUrl, objectHttpEntity, JSONObject.class);

        Integer code = result.getInteger("return_code");
        if (code.equals(200)) {
            //成功记录日志到数据库
            String commentId = result.getString("data");
            Comment comment = new Comment();
            comment.setId(UUID.randomUUID().toString());
            comment.setResourceId(params.get("resourceId"));
            comment.setUuid(params.get("uuid"));
            comment.setScore(params.get("score"));
            comment.setContent(params.get("content"));
            comment.setCommentId(commentId);
            comment.setCreateTime(createTime);
            comment.setJudgeComment(1);
            commentRepository.save(comment);
        }
        result.put("createTime", createTime);
        return result;
    }

    /**
     * 回复
     *
     * @param params
     * @return
     */
    public JSONObject reply(Map<String, String> params, Long start, Long end) {

        Long createTime = DateUtil.random(start, end);
        params.put("createTime", createTime.toString());
        HttpEntity<Map<String, Object>> objectHttpEntity = new HttpEntity(params, httpHeaders);
        JSONObject result = restTemplate.postForObject(replyUrl, objectHttpEntity, JSONObject.class);

        Integer code = result.getInteger("return_code");
        if (code.equals(200)) {
            //成功记录日志到数据库
            String data = result.getString("data");
            Comment comment = new Comment();
            comment.setId(UUID.randomUUID().toString());
            comment.setResourceId(params.get("resourceId"));
            comment.setUuid(params.get("uuid"));
            comment.setScore(params.get("score"));
            comment.setContent(params.get("content"));
            comment.setCommentId(params.get("commentId"));
            comment.setReplyId(data);
            comment.setCreateTime(createTime);
            comment.setJudgeComment(0);
            commentRepository.save(comment);
        }
        result.put("createTime", createTime);
        return result;
    }


    public String getRandomUUid(List<String[]> uuids) {
        Random random = new Random();
        int index = random.nextInt(uuids.size());
        return uuids.get(index)[0];
    }


}
