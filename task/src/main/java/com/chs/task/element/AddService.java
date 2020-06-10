package com.chs.task.element;

import org.springframework.stereotype.Component;

/**
 * @author : HongSheng.Chen
 * @date : 2020/5/22 10:23
 */
@Component
public class AddService {

    private Integer count;
    public void add(){
        count++;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
