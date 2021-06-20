package com.chs.activity.modal.enums;

/**
 * @author : HongSheng.Chen
 * @date : 2021/4/9 9:59
 */
public enum TypeEnum {

    /**
     * 热游
     */
    HOT(1),

    /**
     * 经典
     */
    CLASSIC(2),
  
    ;

    private Integer label;


    TypeEnum(Integer label) {
        this.label = label;
    }

    public Integer getLabel() {
        return label;
    }
}
