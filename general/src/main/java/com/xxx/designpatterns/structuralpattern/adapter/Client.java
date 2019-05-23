package com.xxx.designpatterns.structuralpattern.adapter;

/**
 * 客户端
 *
 * @author guodq
 * @create 2018-09-下午4:52
 */

public class Client {

    public static void print(Target t){
        t.handle();
    }

    public static void main(String[] args) {
        Adaptee a = new Adaptee();
        Target t = new Adapter(a);
        print(t);
    }

}
