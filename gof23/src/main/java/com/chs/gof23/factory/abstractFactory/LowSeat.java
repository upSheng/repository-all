package com.chs.gof23.factory.abstractFactory;

class LowSeat implements Seat {

    @Override
    public void massage() {
        System.out.println("不能按摩！");
    }

}
