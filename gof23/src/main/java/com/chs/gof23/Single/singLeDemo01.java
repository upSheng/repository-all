package com.chs.gof23.Single;

/**
 * 单例模式
 *
 * 饿汉式
 * 无懒加载，执行效率高
 */
public class singLeDemo01 {
    private static Dog dog = new Dog();

    private singLeDemo01() {}

    public static Dog getInstance(){
        return dog;
    }

}
