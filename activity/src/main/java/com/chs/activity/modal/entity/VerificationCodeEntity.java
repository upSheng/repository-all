package com.chs.activity.modal.entity;


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

public class VerificationCodeEntity {


    private Integer id;
    private String phone;
    private String code;
    private LocalDateTime createTime;
}
