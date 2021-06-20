package com.chs.activity.modal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserEntity {

    private Integer id;
    private String name;
    private String password;

    private Integer member;
    private Integer admin;
    private String phone;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}