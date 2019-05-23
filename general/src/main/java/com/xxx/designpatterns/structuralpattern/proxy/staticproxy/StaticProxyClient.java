package com.xxx.designpatterns.structuralpattern.proxy.staticproxy;

/**
 * @author guodq
 * @create 2018-10-25 上午11:53
 */

public class StaticProxyClient {
    public static void main(String[] args) {
        Subject realSub = new RealSub();

        Subject subject = new StaticSubProxy(realSub);

        subject.doSomething();
    }
}
