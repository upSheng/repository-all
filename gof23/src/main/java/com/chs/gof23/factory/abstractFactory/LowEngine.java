package com.chs.gof23.factory.abstractFactory;

class LowEngine implements Engine{

    @Override
    public void run() {
        System.out.println("转的慢！");
    }

    @Override
    public void start() {
        System.out.println("启动慢!");
    }

}
