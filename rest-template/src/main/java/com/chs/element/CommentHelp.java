package com.chs.element;

import com.alibaba.fastjson.JSONObject;
import com.chs.entity.Comment;
import com.chs.entity.CommentData;
import com.chs.repository.CommentDataRepository;
import com.chs.repository.CommentRepository;
import com.chs.util.CsvUtil;
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

import java.util.*;

@Component
public class CommentHelp {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpHeaders httpHeaders;

    @Autowired
    private CommentRepository commentRepository;


    @Autowired
    private CommentDataRepository commentDataRepository;


    private static final String COMMENT_URL = "http://pre.233xyx.com/apiserv/bbs/addComment";
    private static final String REPLY_URL = "http://pre.233xyx.com/apiserv/bbs/addReply";

    private static final String DEL_COMMENT_URL = "http://pre.233xyx.com/apiserv/bbs/delComment";
    private static final String DEL_REPLY_URL = "http://pre.233xyx.com/apiserv/bbs/delReply";

    private static final String MODIFY_START_COUNT_URL = "http://pre.233xyx.com/apiserv/bbs/modifyStarCount";

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
            //修改点赞数
            JSONObject startResult = modifyStarCountComment(comment);
        } else {
            System.out.println(result.toJSONString() + params.get("uuid").toString());

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
    public boolean reply(Map<String, String> params, Long start, Long end) {

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

            //修改点赞数
            JSONObject startResult = modifyStarCountReply(comment);
            return true;
        } else {
            System.out.println(result.toJSONString() + params.get("uuid").toString());
            return false;
        }

    }


    /**
     * 读数据库 删除评论 和回复
     */
    public void delCommentAndReply() {
        Page<Comment> pa = commentRepository.findAll(PageRequest.of(0, 500));
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


    public String getRandomUUid(List<List<String>> uuids) {
        Random random = new Random();
        int index = random.nextInt(uuids.size());
        return uuids.get(index).get(0);
    }


    /**
     * 将excel载入数据库
     *
     * @param filePath
     */
    public void loadData(String filePath) {
        List<List<String>> lists = CsvUtil.getExcel(filePath);

        for (List<String> list : lists) {
            CommentData commentData = new CommentData();
            commentData.setId(UUID.randomUUID().toString());
            commentData.setResourceId(list.get(0));
            commentData.setScore(list.get(1));
            commentData.setContent(list.get(2));

            if (3 < list.size()) {
                commentData.setReplya(list.get(3));
            }
            if (4 < list.size()) {
                commentData.setReplyb(list.get(4));
            }
            if (5 < list.size()) {
                commentData.setReplyc(list.get(5));
            }
            if (6 < list.size()) {
                commentData.setReplyd(list.get(6));
            }

            try {

                commentDataRepository.save(commentData);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }


    /**
     * 修改评论点赞
     *
     * @param comment
     * @return
     */
    public JSONObject modifyStarCountComment(Comment comment) {

        Map<String, Object> params = new HashMap<>();
        params.put("moduleType", "GAME");
        params.put("resourceId", comment.getResourceId());
        params.put("commentId", comment.getCommentId());
        params.put("count", randomStar(comment.getContent()));
        params.put("adminName", "adminAuto");
        HttpEntity<Map<String, Object>> objectHttpEntity = new HttpEntity(params, httpHeaders);
        JSONObject result = restTemplate.postForObject(MODIFY_START_COUNT_URL, objectHttpEntity, JSONObject.class);
        return result;
    }

    /**
     * 修改回复点赞
     *
     * @param comment
     * @return
     */
    public JSONObject modifyStarCountReply(Comment comment) {

        Map<String, Object> params = new HashMap<>();
        params.put("moduleType", "GAME");
        params.put("resourceId", comment.getResourceId());
        params.put("replyId", comment.getReplyId());
        params.put("count", randomStar(comment.getContent()));
        params.put("adminName", "adminAuto");
        HttpEntity<Map<String, Object>> objectHttpEntity = new HttpEntity(params, httpHeaders);
        JSONObject result = restTemplate.postForObject(MODIFY_START_COUNT_URL, objectHttpEntity, JSONObject.class);
        return result;
    }


    /**
     * 根据评论字数随机点赞
     *
     * @param content
     * @return
     */
    private int randomStar(String content) {
        if (content == null) {
            return 0;
        }

        if (content.length() < 29) {
            return 3 + (int) (Math.random() * 12);
        } else if (content.length() < 49) {
            return 10 + (int) (Math.random() * 20);
        } else {
            return 20 + (int) (Math.random() * 30);
        }
    }

}
