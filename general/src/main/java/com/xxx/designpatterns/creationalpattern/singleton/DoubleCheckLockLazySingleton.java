package com.xxx.designpatterns.creationalpattern.singleton;

public class DoubleCheckLockLazySingleton {


    private static DoubleCheckLockLazySingleton singleton;

    private DoubleCheckLockLazySingleton(){

    }

    public static DoubleCheckLockLazySingleton getSingleton(){
        if (singleton == null) {
            DoubleCheckLockLazySingleton sc;
            synchronized (DoubleCheckLockLazySingleton.class) {
                sc = singleton;
                if (sc == null) {
                    synchronized (DoubleCheckLockLazySingleton.class) {
                        if(sc == null) {
                            sc = new DoubleCheckLockLazySingleton();
                        }
                    }
                    singleton = sc;
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        System.out.println(LazySingleton.getSingleton());
        System.out.println(LazySingleton.getSingleton());
        System.out.println(LazySingleton.getSingleton());
    }
}


class DoubleCheckLockVolatileLazySingleton{
    private static volatile DoubleCheckLockVolatileLazySingleton singleton;

    private DoubleCheckLockVolatileLazySingleton(){

    }

    public static DoubleCheckLockVolatileLazySingleton getSingleton(){
        if (singleton == null){
            synchronized (DoubleCheckLockVolatileLazySingleton.class){
                singleton = new DoubleCheckLockVolatileLazySingleton();
                return singleton;
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        System.out.println(DoubleCheckLockVolatileLazySingleton.getSingleton());
        System.out.println(DoubleCheckLockVolatileLazySingleton.getSingleton());
        System.out.println(DoubleCheckLockVolatileLazySingleton.getSingleton());
    }
}


