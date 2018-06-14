package com.xxx.innerclass;

public class TT {

    public static void main(String[] args) {
        DD.staticAA().toString();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("b");
            }
        };
        AAA a = new AAA();
//        a.clone();


    }
}

class AAA implements Runnable{
    @Override
    public void run() {
        System.out.println("bb");
    }

    public AAA() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}


interface TTUUU{

}

@FunctionalInterface
interface UU{
    String ff = "f";
    void clone1();
//    static String clone(Integer i){
//        return "fdsfad";
//    }

     static UU staticAA(){
        System.out.println("fff");
        return () ->{};
    }

    default void tt(){
        System.out.println("tt");
    }
//    Object colne();
}

@FunctionalInterface
interface DD extends UU{

    static UU staticAA(){
        System.out.println("eeee");
        return () ->{};
    }

//    static String a{
//        return "f";
//    }
}


