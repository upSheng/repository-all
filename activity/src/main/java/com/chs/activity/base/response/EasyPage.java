package com.chs.activity.base.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author : HongSheng.Chen
 * @date : 2021/2/18 16:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EasyPage<T> {

    private List<T> content;
    private Long count;
}
