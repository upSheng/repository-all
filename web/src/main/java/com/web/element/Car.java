package com.web.element;

import org.springframework.stereotype.Component;

/**
 * @author : HongSheng.Chen
 * @date : 2020/7/23 15:05
 */
@Component
public class Car {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sing(){
        System.out.println("car sing");
    }

}
