package com.xxx.designpatterns.creationalpattern.abstractfactory;

/**
 * 轮胎
 *
 * @author guodq
 * @create 2018-06-下午6:56
 */

public interface Tyre {
    void run();
}

class HighTyre implements Tyre{
    @Override
    public void run() {
        System.out.println("好的轮胎");
    }
}

class LowTyre implements Tyre{
    @Override
    public void run() {
        System.out.println("不好的轮胎");
    }
}
