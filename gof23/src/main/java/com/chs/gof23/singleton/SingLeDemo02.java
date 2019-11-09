package com.chs.gof23.singleton;

/**
 * 单例模式
 *
 * 懒汉式
 * 有懒加载，执行效率低
 */
public class SingLeDemo02 {
    private static SingLeDemo02 singLeDemo02 ;

    private SingLeDemo02() {}

    public synchronized static SingLeDemo02 getInstance(){

        if(singLeDemo02==null){
            singLeDemo02 = new SingLeDemo02();
        }

        return singLeDemo02;
    }

}
