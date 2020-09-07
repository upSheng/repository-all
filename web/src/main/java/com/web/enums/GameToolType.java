package com.web.enums;

/**
 * @author : HongSheng.Chen
 * @date : 2020/7/21 16:01
 */
public enum GameToolType {

    GAME_SECREC_CODE(1,"密令");

    private String name;
    private Integer val;

    GameToolType(Integer val,String name) {
        this.name = name;
        this.val = val;
    }
}
