package com.chs.activity.modal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "user")
public class UserEntity {

    private String id;
    private String name;
    private String password;
    private String role;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}