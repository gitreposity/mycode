package com.xxx.designpatterns.creationalpattern.singleton;

public class LazySingleton {

    private static LazySingleton singleton;

    private LazySingleton(){

    }

    public static LazySingleton getSingleton(){
        if (singleton == null){
            singleton = new LazySingleton();
            return singleton;
        }
        return singleton;
    }

    public static void main(String[] args) {
        System.out.println(LazySingleton.getSingleton());
        System.out.println(LazySingleton.getSingleton());
        System.out.println(LazySingleton.getSingleton());
    }
}
