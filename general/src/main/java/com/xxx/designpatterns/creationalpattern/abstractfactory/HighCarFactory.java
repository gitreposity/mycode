package com.xxx.designpatterns.creationalpattern.abstractfactory;

/**
 * 高级车的工厂
 *
 * @author guodq
 * @create 2018-06-下午7:08
 */

public class HighCarFactory implements CarFactory{


    @Override
    public Seat createSeat() {
        return new HighSeat();
    }

    @Override
    public Tyre createTyre() {
        return new HighTyre();
    }

    @Override
    public Engine createEngine() {
        return new HighEngine();
    }
}
