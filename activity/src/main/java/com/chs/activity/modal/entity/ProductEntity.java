package com.chs.activity.modal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author : HongSheng.Chen
 * @date : 2021/2/18 11:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "product")
public class ProductEntity {


    private String id;
    private String name;
    private String describe;
    private Integer price;
    private Integer oriPrice;
    private String img;
    private Integer quantity;
    private Integer label;
    private String key;

    /**
     * 权重
     */
    private Integer weight;
    private String steamUrl;
    private List<String> tagList;
    private String account;
    private String password;

    private String video;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
