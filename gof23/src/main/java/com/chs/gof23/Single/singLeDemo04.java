package com.chs.gof23.Single;

/**
 * 单例模式
 *
 * 枚举
 */
public enum  singLeDemo04 {

    instance;

    private String name;
    public void hello(){
        System.out.println("hello" + this.name);
    }
    public void setName(String name){
        this.name = name;
    }


    public static void main(String[] args) {
        singLeDemo04.instance.hello();
        singLeDemo04.instance.setName("111");
        singLeDemo04.instance.hello();
    }

}
