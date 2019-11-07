package com.chs.gof23.Single;

/**
 * 单例模式
 *
 * 懒汉式
 * 有懒加载，执行效率低
 */
public class SingLeDemo02 {
    private static Dog dog ;

    private SingLeDemo02() {}

    public synchronized static Dog getInstance(){

        if(dog==null){
            dog = new Dog();
        }

        return dog;
    }

}
