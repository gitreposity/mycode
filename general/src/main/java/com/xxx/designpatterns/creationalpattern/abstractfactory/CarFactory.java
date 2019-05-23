package com.xxx.designpatterns.creationalpattern.abstractfactory;

/**
 * 车的工厂
 *
 * @author guodq
 * @create 2018-06-下午7:06
 */

public interface CarFactory {

    Seat createSeat();

    Tyre createTyre();

    Engine createEngine();

}
