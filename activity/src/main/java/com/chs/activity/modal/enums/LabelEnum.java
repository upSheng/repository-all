package com.chs.activity.modal.enums;

/**
 * @author : HongSheng.Chen
 * @date : 2021/4/9 9:59
 */
public enum LabelEnum {

    /**
     * 热游
     */
    HOT(1),

    /**
     * 经典
     */
    CLASSIC(2),
    /**
     * 免费
     */
    FREE(3),
    ;

    private Integer label;


    LabelEnum(Integer label) {
        this.label = label;
    }

    public Integer getLabel() {
        return label;
    }
}
