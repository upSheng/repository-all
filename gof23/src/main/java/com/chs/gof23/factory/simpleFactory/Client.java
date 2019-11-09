package com.chs.gof23.factory.simpleFactory;

public class Client {

    public static void main(String[] args) {
        Animal cat = AnimalFactory.getCat();
        cat.run();

    }
}
