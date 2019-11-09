package com.chs.gof23.factory.abstractFactory;

class LuxurySeat implements Seat {

    @Override
    public void massage() {
        System.out.println("可以自动按摩！");
    }

}
