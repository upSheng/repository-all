package com.chs.activity.modal.entity;


import com.chs.activity.modal.bean.heybox.GameInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author : HongSheng.Chen
 * @date : 2021/2/18 11:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class GameEntity {


    private Integer id;
    private String name;
    private String nameEn;
    private String appId;
    private Integer price;
    private Integer oriPrice;
    private Integer weight;
    private String exe;

    private String steamUrl;
    private String steamImg;
    private String info;
    private GameInfo gameInfo;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
