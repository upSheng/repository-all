package com.chs.gof23.singleton;

/**
 * 单例模式
 *
 * 饿汉式
 * 无懒加载，执行效率高
 */
public class SingLeDemo01 {
    private static SingLeDemo01 singLeDemo01 = new SingLeDemo01();

    private SingLeDemo01() {}

    public static SingLeDemo01 getInstance(){
        return singLeDemo01;
    }

}
