package com.xxx.test;



public class Test {

    static private String aa;

    public String getAa() {
        return "ss";
    }

    public void setAa(String aa) {
        this.aa = aa;
    }

    public static void main(String[] args) {
        Test t  = new Test();
        t.setAa("44");
        System.out.println(aa);
    }

    static void a(StringBuffer b){

    }



}
