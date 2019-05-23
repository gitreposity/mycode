package com.xxx.designpatterns.creationalpattern.abstractfactory;

/**
 * 客户端
 *
 * @author guodq
 * @create 2018-06-下午7:10
 */

public class client {
    public static void main(String[] args) {
        CarFactory carFactory = new HighCarFactory();
        carFactory.createEngine().run();
        carFactory.createSeat().feat();
        carFactory.createTyre().run();
    }
}
