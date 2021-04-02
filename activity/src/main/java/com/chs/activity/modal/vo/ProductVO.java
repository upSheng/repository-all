package com.chs.activity.modal.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author : HongSheng.Chen
 * @date : 2021/4/1 10:04
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ProductVO {

    private String id;
    private String name;
    private String describe;
    private Integer price;
    private String img;
    private Integer quantity;
    private List<String> tagList;

    private String steamUrl;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}