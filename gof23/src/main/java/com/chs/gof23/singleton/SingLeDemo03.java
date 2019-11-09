package com.chs.gof23.singleton;

/**
 * 单例模式
 *
 * 内部静态类
 */
public class SingLeDemo03 {
    private static class singleClass{
        private static final SingLeDemo03 singLeDemo03 = new SingLeDemo03()  ;
    }

    private SingLeDemo03() {}

    public static SingLeDemo03 getInstance(){


        return singleClass.singLeDemo03;
    }

}
