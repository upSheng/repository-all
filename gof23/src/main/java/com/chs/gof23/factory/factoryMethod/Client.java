package com.chs.gof23.factory.factoryMethod;

public class Client {

    public static void main(String[] args) {
        Animal cat = new CarFactory().createAnimal();
        cat.run();

    }
}
