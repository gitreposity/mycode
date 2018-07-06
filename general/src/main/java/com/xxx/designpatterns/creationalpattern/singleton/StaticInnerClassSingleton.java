package com.xxx.designpatterns.creationalpattern.singleton;

public class StaticInnerClassSingleton {

    private StaticInnerClassSingleton(){

    }

    private static class SingletonLoad{
        private static final StaticInnerClassSingleton singleton = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getSingleton(){
        return SingletonLoad.singleton;
    }
}
