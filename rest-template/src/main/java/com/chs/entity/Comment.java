package com.chs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

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

    @Column(name = "GAME_ID")
    private String gameId;

    @Column(name = "SCORE")
    private Integer score;

    @Column(name = "COMMENT")
    private String comment;

    @Column(name = "COMMENTA")
    private String commenta;

    @Column(name = "COMMENTB")
    private String commentb;

    @Column(name = "COMMENTC")
    private String commentc;

    @Column(name = "COMMENTD")
    private String commentd;

    @Column(name = "UUID")
    private String uuid;

    @Column(name = "CREATE_TIME")
    private Long createTime;

    @Column(name = "COMMENT_ID")
    private String commentId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getCommenta() {
        return commenta;
    }

    public void setCommenta(String commenta) {
        this.commenta = commenta;
    }

    public String getCommentb() {
        return commentb;
    }

    public void setCommentb(String commentb) {
        this.commentb = commentb;
    }

    public String getCommentc() {
        return commentc;
    }

    public void setCommentc(String commentc) {
        this.commentc = commentc;
    }

    public String getCommentd() {
        return commentd;
    }

    public void setCommentd(String commentd) {
        this.commentd = commentd;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
