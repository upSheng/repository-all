package com.chs.gof23.Single;

/**
 * 单例模式
 *
 * 内部静态类
 */
public class SingLeDemo03 {
    private static class singleClass{
        private static final Dog dog = new Dog()  ;
    }

    private SingLeDemo03() {}

    public static Dog getInstance(){


        return singleClass.dog;
    }

}
