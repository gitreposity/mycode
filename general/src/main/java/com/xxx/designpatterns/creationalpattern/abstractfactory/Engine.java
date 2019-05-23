package com.xxx.designpatterns.creationalpattern.abstractfactory;

/**
 * 引擎
 *
 * @author guodq
 * @create 2018-06-下午7:03
 */
public interface Engine {

    void run();
}

class HighEngine implements Engine{
    @Override
    public void run() {
        System.out.println("高端引擎");
    }
}

class LowEngine implements Engine{
    @Override
    public void run() {
        System.out.println("一般的引擎");
    }
}
