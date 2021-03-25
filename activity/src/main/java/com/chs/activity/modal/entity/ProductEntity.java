package com.chs.activity.modal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

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
    private String img;

}
