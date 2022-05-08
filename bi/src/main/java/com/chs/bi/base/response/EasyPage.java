package com.chs.bi.base.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EasyPage<T> {

    private List<T> content;
    private Long totalCount;
}
