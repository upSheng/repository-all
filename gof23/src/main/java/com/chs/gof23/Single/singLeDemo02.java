package com.chs.gof23.Single;

/**
 * 单例模式
 *
 * 懒汉式
 * 有懒加载，执行效率低
 */
public class singLeDemo02 {
    private static Dog dog ;

    private singLeDemo02() {}

    public synchronized static Dog getInstance(){

        if(dog==null){
            dog = new Dog();
        }

        return dog;
    }

}
