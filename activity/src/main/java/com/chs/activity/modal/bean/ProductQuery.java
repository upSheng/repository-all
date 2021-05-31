package com.chs.activity.modal.bean;

import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * @author : HongSheng.Chen
 * @date : 2021/4/1 10:07
 */
@Data
public class ProductQuery {

    private Integer pageNum;
    private Integer pageSize;
    private Integer label;
    private Integer free;
    private String keys;
    private String userId;
    private Integer own;
    private Set<String> productIdSet;
}
