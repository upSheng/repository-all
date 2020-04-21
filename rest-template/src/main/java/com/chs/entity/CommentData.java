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
@Table(name = "COMMENT_DATA")
public class CommentData {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "RESOURCE_Id")
    private String resourceId;

    @Column(name = "SCORE")
    private String score;

    @Column(name = "CONTENT")
    private String content;


    @Column(name = "REPLYA")
    private String replya;

    @Column(name = "REPLYB")
    private String replyb;

    @Column(name = "REPLYC")
    private String replyc;

    @Column(name = "REPLYD")
    private String replyd;

    @Column(name = "RESULT")
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

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReplya() {
        return replya;
    }

    public void setReplya(String replya) {
        this.replya = replya;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getReplyb() {
        return replyb;
    }

    public void setReplyb(String replyb) {
        this.replyb = replyb;
    }

    public String getReplyc() {
        return replyc;
    }

    public void setReplyc(String replyc) {
        this.replyc = replyc;
    }

    public String getReplyd() {
        return replyd;
    }

    public void setReplyd(String replyd) {
        this.replyd = replyd;
    }
}
