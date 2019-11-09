package com.chs.gof23.factory.abstractFactory;

class LuxuryEngine implements Engine{

    @Override
    public void run() {
        System.out.println("转的快！");
    }

    @Override
    public void start() {
        System.out.println("启动快!可以自动启停！");
    }

}
