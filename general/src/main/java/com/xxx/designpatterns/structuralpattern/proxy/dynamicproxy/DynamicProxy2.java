package com.xxx.designpatterns.structuralpattern.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 2
 *
 * @author guodq
 * @create 2018-10-25 下午2:36
 */

public class DynamicProxy2 implements InvocationHandler{

    private Object proxyObj;

    public Object bind(Object object){
        proxyObj =  object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理类开始执行");
        Object  object = method.invoke(proxyObj,args);
        System.out.println("代理类开始执行结束");
        return object;
    }
}
