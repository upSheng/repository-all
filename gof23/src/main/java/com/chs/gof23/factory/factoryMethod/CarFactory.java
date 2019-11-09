package com.chs.gof23.factory.factoryMethod;

public class CarFactory implements AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}
