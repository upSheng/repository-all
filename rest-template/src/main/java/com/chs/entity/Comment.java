package com.chs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陈洪生<br>
 * <b>mail</b> chenhongsheng@tansun.com.cn<br>
 * <b>date</b> 2019/9/21<br>
 * @version 1.0.1
 * <pre>
 * 版本            修改人            修改日期            修改内容描述
 * --------------------------------------------------------------------
 * 1.0.1 	       陈洪生	        2019/9/21            创建
 * --------------------------------------------------------------------
 * </pre>
 */

@Entity
@Table(name = "COMMENT")
public class Comment {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "resourceId")
    private String resourceId;

    @Column(name = "UUID")
    private String uuid;

    @Column(name = "SCORE")
    private String score;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "CREATE_TIME")
    private Long createTime;

    @Column(name = "COMMENT_ID")
    private String commentId;

    @Column(name = "REPLY_ID")
    private String replyId;

    @Column(name = "JUDGE_COMMENT")
    private Integer judgeComment;

    @Column(name = "result")
    private String result;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getReplyId() {
        return replyId;
    }

    public void setReplyId(String replyId) {
        this.replyId = replyId;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Integer getJudgeComment() {
        return judgeComment;
    }

    public void setJudgeComment(Integer judgeComment) {
        this.judgeComment = judgeComment;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
