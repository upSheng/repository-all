package com.chs.gof23.Single;

/**
 * 单例模式
 *
 * 枚举
 */
public enum SingLeDemo04 {

    instance;

    private String name;
    public void hello(){
        System.out.println("hello" + this.name);
    }
    public void setName(String name){
        this.name = name;
    }


    public static void main(String[] args) {
        SingLeDemo04.instance.hello();
        SingLeDemo04.instance.setName("111");
        SingLeDemo04.instance.hello();
    }

}
