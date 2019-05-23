package com.xxx.designpatterns.structuralpattern.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * @author guodq
 * @create 2018-10-25 上午11:17
 */

public class DynamicProxyClient {

    public static void main(String[] args) {
//        Subject realSub = new RealSub();
//        ClassLoader myClassLoader = realSub.getClass().getClassLoader();
//        DynamicSub dynamicSub = new DynamicSub(realSub);
//        Class[] classes = new Class[]{Subject.class};
//        Subject subject = (Subject) Proxy.newProxyInstance(myClassLoader,classes,dynamicSub);
//        subject.doSomething();
        DynamicProxy2 dynamicSub = new DynamicProxy2();
        Subject subject = (Subject) dynamicSub.bind(new RealSub());
        subject.doSomething();
        subject.doSomething2();

    }
}
