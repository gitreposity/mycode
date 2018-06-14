package com.xxx.functioninterface;

public class Test {

    public static void main(String[] args) {
        FunctionalInterface1 functionalInterface = new FunctionalInterface1(){
            @Override
            public String uuuuu() {
                return null;
            }
        };
        FunctionalInterface1 f = new B();
        ((B) f).ttttt();


        System.out.println(functionalInterface.toString());
    }
}


interface FunctionalInterface1{

    String uuuuu();


}

class B implements FunctionalInterface1{

    @Override
    public String uuuuu() {
        return null;
    }

    void ttttt(){

    }
}

interface BB{


}

class UU implements BB{
    @Override
    public String clone() {
        return null;
    }
}

