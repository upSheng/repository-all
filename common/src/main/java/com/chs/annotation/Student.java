package com.chs.annotation;

@MyTable(value = "STUDENT")
public class Student {

    @MyField(name = "ID", length = 10)
    private String  id;

    @MyField(name = "AGE", length = 10)
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
