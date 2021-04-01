package com.chs.activity.modal.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author : HongSheng.Chen
 * @date : 2021/4/1 13:54
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderAward {

    private LocalDateTime createTime;
    private String name;
    private String transactionId;
    private String account;
    private String password;
}
