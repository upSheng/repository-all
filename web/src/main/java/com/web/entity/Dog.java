package com.web.entity;

import org.hibernate.exception.DataException;

import java.util.Date;

/**
 * @author : HongSheng.Chen
 * @date : 2020/8/24 20:23
 */
public class Dog {

    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
