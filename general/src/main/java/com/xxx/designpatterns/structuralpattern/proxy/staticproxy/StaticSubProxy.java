package com.xxx.designpatterns.structuralpattern.proxy.staticproxy;

/**
 * @author guodq
 * @create 2018-10-25 上午11:51
 */

public class StaticSubProxy implements Subject {

    private Subject proxySub;

    public StaticSubProxy(Subject subject){
        proxySub = subject;
    }

    @Override
    public void doSomething() {
        proxySub.doSomething();
    }
}
