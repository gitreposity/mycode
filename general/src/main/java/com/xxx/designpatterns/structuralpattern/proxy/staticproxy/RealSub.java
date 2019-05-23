package com.xxx.designpatterns.structuralpattern.proxy.staticproxy;

/**
 * @author guodq
 * @create 2018-10-25 上午11:49
 */

public class RealSub implements Subject {

    @Override
    public void doSomething() {
        System.out.println("real do something");
    }
}
