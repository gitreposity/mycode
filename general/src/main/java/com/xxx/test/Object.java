package com.xxx.test;

import lombok.Data;

/**
 * 对象测试
 *
 * @author guodq
 * @create 2018-16-下午10:40
 */

public class Object {
    public static void main(String[] args) {
//        A a = new A();
//        B b = (B) a;
        B b = new B();
        b.setAge(1);
        System.out.println(b);
        cast(b);
    }

    static void cast(A a){
        B b = (B) a;
        System.out.println(b.getAge());
    }
}

@Data
class A{
    private Integer id;
}


@Data
class B extends A{
    private Integer age;
}
