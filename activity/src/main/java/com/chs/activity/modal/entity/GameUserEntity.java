package com.chs.activity.modal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Builder
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class GameUserEntity {
    private Integer id;
    private String phone;
    private Integer gameId;
    private String orderId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
