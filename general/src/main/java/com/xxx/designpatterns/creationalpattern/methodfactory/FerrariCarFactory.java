package com.xxx.designpatterns.creationalpattern.methodfactory;



/**
 * 生产车
 *
 * @author guodq
 * @create 2018-06-下午5:45
 */

public class FerrariCarFactory implements CarFactory{

    @Override
    public Car createCar() {
        return new Ferrari();
    }
}
