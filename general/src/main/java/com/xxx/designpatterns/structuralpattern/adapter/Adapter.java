package com.xxx.designpatterns.structuralpattern.adapter;

/**
 * 适配器
 *
 * @author guodq
 * @create 2018-09-下午4:51
 */

public class Adapter implements Target{

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void handle() {
        adaptee.request();
    }
}
