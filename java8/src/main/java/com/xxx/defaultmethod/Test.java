package com.xxx.defaultmethod;

import com.google.common.collect.Lists;

import java.util.Collection;

public class Test {

    public static void main(String[] args) {

        // removeIf   forEach
//        Collection<Integer> list = Lists.newLinkedList();
//        list.add(1);
//        list.add(2);
//        list.removeIf(o -> o.equals(1));
//        list.forEach(System.out::println);

        // 问题？Arrays.List为什么要重新定义上面两个方法

        DefaultMethod.get().excu();
        DefaultMethod.info();
    }

}

interface DefaultMethod{

    void walk();

    void run();

    default void excu(){
        walk();
        run();
    }

    static DefaultMethod get(){
        return new DefaultMethod(){
            @Override
            public void walk() {
                System.out.println("我在走路");
            }

            @Override
            public void run() {
                System.out.println("我在跑步");
            }
        };
    }

    static  void info(){
        System.out.println("ddd");
    }

}

