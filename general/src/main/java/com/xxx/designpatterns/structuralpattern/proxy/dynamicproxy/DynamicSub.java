package com.xxx.designpatterns.structuralpattern.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * a
 *
 * @author guodq
 * @create 2018-10-25 上午11:12
 */

public class DynamicSub implements InvocationHandler{

    private Object myObject;

    public DynamicSub(Object object) {
        myObject = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(myObject,args);
    }
}
