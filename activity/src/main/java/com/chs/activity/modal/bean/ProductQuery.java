package com.chs.activity.modal.bean;

import lombok.Data;

/**
 * @author : HongSheng.Chen
 * @date : 2021/4/1 10:07
 */
@Data
public class ProductQuery {

    private Integer pageNum;
    private Integer pageSize;
    private String name;
}
