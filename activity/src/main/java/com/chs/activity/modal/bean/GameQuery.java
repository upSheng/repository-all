package com.chs.activity.modal.bean;

import lombok.Data;

/**
 * @author : HongSheng.Chen
 * @date : 2021/4/1 10:07
 */
@Data
public class GameQuery {

    private Integer pageNum;
    private Integer pageSize;
    private String appId;
    private String name;

    public Integer getPageNum() {
        return pageNum == null ? 1 : pageNum;
    }

    public Integer getPageSize() {
        return pageSize == null ? 10 : pageSize;
    }
}
