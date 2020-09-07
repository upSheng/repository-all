package com.chs.note.consumer;

import java.util.function.Consumer;

/**
 * @author : HongSheng.Chen
 * @date : 2020/6/19 11:00
 */
public class consumerTest {

    private static void ad(Consumer consumer){
        String a ="aa";
        consumer.andThen(x-> System.out.println("b")).andThen(x-> System.out.println("c")).accept(a);
    }

    public static void main(String[] args) {

        ad(System.out::println);
    }
}
