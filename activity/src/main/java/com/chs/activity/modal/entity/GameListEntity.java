package com.chs.activity.modal.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GameListEntity {
    private Integer id;
    private String name;
    private Integer price;
    private String gameList;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
