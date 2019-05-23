package com.xxx.designpatterns.creationalpattern.simplefactory;

/**
 * 客户端
 *
 * @author guodq
 * @create 2018-06-下午5:38
 */

public class Client {
    public static void main(String[] args) {
        Car car = CarFactory.createFerrari();
        car.run();
        car = CarFactory.createTesla();
        car.run();
    }
}
class Old{
    public static void main(String[] args) {
        Car car = new Ferrari();
        car.run();
        car = new Tesla();
        car.run();
    }
}
