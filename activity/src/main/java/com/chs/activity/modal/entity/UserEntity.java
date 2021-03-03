package com.chs.activity.modal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserEntity {
    private Integer id;

    private Integer age;

    private LocalDateTime createTime;

    private String createUser;

    private String name;

    private String password;

}