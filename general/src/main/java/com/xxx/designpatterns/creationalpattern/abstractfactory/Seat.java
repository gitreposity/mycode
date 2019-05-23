package com.xxx.designpatterns.creationalpattern.abstractfactory;

/**
 * 座椅
 *
 * @author guodq
 * @create 2018-06-下午7:05
 */

public interface Seat {

    void feat();
}

class HighSeat implements Seat{
    @Override
    public void feat() {
        System.out.println("好的座椅");

    }
}

class LowSeat implements Seat{
    @Override
    public void feat() {
        System.out.println("坏的座椅");
    }
}
