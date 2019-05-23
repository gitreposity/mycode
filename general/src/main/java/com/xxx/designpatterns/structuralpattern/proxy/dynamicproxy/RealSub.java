package com.xxx.designpatterns.structuralpattern.proxy.dynamicproxy;

/**
 * @author guodq
 * @create 2018-10-25 上午11:11
 */

public class RealSub implements Subject{

    @Override
    public void doSomething() {
        System.out.println("Real DoSomething");
    }

    @Override
    public void doSomething2() {
        System.out.println("Real DoSomething2");
    }
}
