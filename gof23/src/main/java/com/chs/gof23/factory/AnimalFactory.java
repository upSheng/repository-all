package com.chs.gof23.factory;

public class AnimalFactory {

    public static Cat getCat(){
        return new Cat();
    }

    public static Dog getDog(){
        return new Dog();
    }

}


