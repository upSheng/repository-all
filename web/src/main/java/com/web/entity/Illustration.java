package com.web.entity;


import lombok.Data;

import java.util.List;

/**
 * @author : HongSheng.Chen
 * @date : 2020/8/21 14:35
 */
@Data
public class Illustration {

    private String image;

    private String name;

    private List<Property> properties;

    private String type;

}
