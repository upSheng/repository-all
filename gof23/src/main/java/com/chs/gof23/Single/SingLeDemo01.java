package com.chs.gof23.Single;

/**
 * 单例模式
 *
 * 饿汉式
 * 无懒加载，执行效率高
 */
public class SingLeDemo01 {
    private static Dog dog = new Dog();

    private SingLeDemo01() {}

    public static Dog getInstance(){
        return dog;
    }

}
