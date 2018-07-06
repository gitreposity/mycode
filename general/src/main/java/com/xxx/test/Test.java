package com.xxx.test;


import com.google.common.collect.Maps;

import java.util.Map;

public class Test {

    public static void main(String[] args) {

        class  U implements Runnable{
            public void run() {
                System.out.println("ss");
            }
        }

        Runnable r = new U();


        r = new Runnable() {
            public void run() {
                System.out.println("ss");
            }
        };

        r = () -> {
            System.out.println("ss");
        };

        new Thread(r).start();

    }
}

class SimpleTest{
    public static void main(String[] args) {
        final Map<Integer,Boolean> map = Maps.newHashMap();
        if ( null != map.get(1)){
            System.out.println("f");
        }
        for (Integer integer : map.keySet()) {
            if ( null != map.get(1));
        }
        System.out.println(map.get(1));
    }
}

class MethodReferenceParameter{
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("bbbb");
        String s = "bbbb";
        convertString(s);
        convertString(stringBuffer);
        System.out.println(s);

        System.out.println(stringBuffer.toString());
    }

    static void convertString(StringBuffer stringBuffer){
        stringBuffer.append("1111");
    }
    static void convertString(String s){
        s += "1";
    }
}

