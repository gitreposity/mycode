package com.xxx.designpatterns.creationalpattern.singleton;

public class LockLazySingleton {

    private static LockLazySingleton singleton;

    private LockLazySingleton(){

    }
    public static synchronized LockLazySingleton getSingleton(){
        if (singleton == null){
            singleton = new LockLazySingleton();
            return singleton;
        }
        return singleton;
    }

//    public static LockLazySingleton getSingleton(){
//        synchronized (singleton){
//            if (singleton == null){
//                singleton = new LockLazySingleton();
//                return singleton;
//            } else{
//                return singleton;
//            }
//        }
//
//    }

    public static void main(String[] args) {
        System.out.println(LazySingleton.getSingleton());
        System.out.println(LazySingleton.getSingleton());
        System.out.println(LazySingleton.getSingleton());
    }
}
