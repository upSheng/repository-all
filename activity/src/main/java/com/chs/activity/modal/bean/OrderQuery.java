package com.chs.activity.modal.bean;

import lombok.Data;

/**
 * @author : HongSheng.Chen
 * @date : 2021/4/1 11:02
 */
@Data
public class OrderQuery {

    private String name;
    private Integer pageNum;
    private Integer pageSize;

}
