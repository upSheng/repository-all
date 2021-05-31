package com.chs.activity.modal.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : HongSheng.Chen
 * @date : 2020/12/24 11:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResVO {
    private String token;
    private String userId;
}
