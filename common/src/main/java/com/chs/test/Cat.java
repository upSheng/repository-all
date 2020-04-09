package com.chs.test;

/**
 * @author : HongSheng.Chen
 * @date : 2020/3/26 15:27
 */
public class Cat {

    private String name;

    Cat(Object object) {
        System.out.println("1");
        this.name = (String) object;
    }

    Cat(String name) {
        System.out.println("2");
        this.name = name;
    }


    private int t() {
        int a;
        int c;


        try {
            a = 1 / 0;
        } finally {
            c = 4;

        }


        return a;
    }

    public static void main(String[] args) {

        Object object = "ccc";

        Cat cat = new Cat(object);

        int c = cat.t();
        return;


    }
}
