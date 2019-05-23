package com.xxx.designpatterns.creationalpattern.methodfactory;

/**
 * a
 *
 * @author guodq
 * @create 2018-06-下午6:03
 */

public class Client {
    public static void main(String[] args) {
        Car car = new FerrariCarFactory().createCar();
        car.run();
        car = new TeslaCarFactory().createCar();
        car.run();
    }
}
