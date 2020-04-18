package com.chs.element;

import com.alibaba.fastjson.JSONObject;
import com.chs.entity.Comment;
import com.chs.repository.CommentRepository;
import com.chs.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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


    private static final String COMMENT_URL = "http://pre.233xyx.com/apiserv/bbs/addComment";
    private static final String REPLY_URL = "http://pre.233xyx.com/apiserv/bbs/addReply";

    private static final String DEL_COMMENT_URL = "http://pre.233xyx.com/apiserv/bbs/delComment";
    private static final String DEL_REPLY_URL = "http://pre.233xyx.com/apiserv/bbs/delReply";

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
        JSONObject result = restTemplate.postForObject(COMMENT_URL, objectHttpEntity, JSONObject.class);

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
        JSONObject result = restTemplate.postForObject(REPLY_URL, objectHttpEntity, JSONObject.class);
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


    /**
     * 读数据库 删除评论 和回复
     */
    public void delCommentAndReply() {
        Page<Comment> pa = commentRepository.findAll(PageRequest.of(1, 1));
        List<Comment> list = pa.getContent();

        for (Comment comment : list) {

            Integer judgeComment = comment.getJudgeComment();

            MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();

            params.add("moduleType", "GAME");
            params.add("resourceId", comment.getResourceId());
            params.add("uuid", comment.getUuid());

            JSONObject result = null;
            if (judgeComment.equals(1)) {
                //删除评论
                params.add("commentId", comment.getCommentId());
                result = restTemplate.postForObject(DEL_COMMENT_URL, params, JSONObject.class);
            }
            if (judgeComment.equals(0)) {
                //删除回复
                params.add("replyId", comment.getReplyId());
                result = restTemplate.postForObject(DEL_REPLY_URL, params, JSONObject.class);
            }

            if (result != null) {
                Integer code = result.getInteger("return_code");
                if (code.equals(200)) {
                    commentRepository.delete(comment);
                }
            }

        }
    }


    public String getRandomUUid(List<String[]> uuids) {
        Random random = new Random();
        int index = random.nextInt(uuids.size());
        return uuids.get(index)[0];
    }


}
