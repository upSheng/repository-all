package com.chs.tool.csv;

import java.util.Date;

/**
 * @author : HongSheng.Chen
 * @date : 2020/5/11 12:03
 */
public class User {

    @CSVField(name = "ID")
    private Integer id;

    @CSVField(name = "名称")
    private String name;

    @CSVField(name = "创建时间")
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
