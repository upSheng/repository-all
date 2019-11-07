package com.chs.gof23.factory;

public class Client {

    public static void main(String[] args) {

        //第一种调用

        Cat cat1 = new Cat();
        cat1.run();


        //第二种调用

        Animal cat2 = AnimalFactory.getCat();
        cat2.run();

        Animal dog2 = AnimalFactory.getDog();
        dog2.run();


    }
}
