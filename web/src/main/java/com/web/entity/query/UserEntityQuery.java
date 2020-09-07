package com.web.entity.query;

import com.web.entity.UserEntity;

import java.util.Date;

/**
 * @author : HongSheng.Chen
 * @date : 2020/7/23 9:33
 */
public class UserEntityQuery extends UserEntity {
    private String startTime;
    private String endTime;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
