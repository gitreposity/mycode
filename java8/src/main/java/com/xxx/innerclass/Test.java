package com.xxx.innerclass;

import com.alibaba.fastjson.JSON;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        Test.A u = test.new A();
        System.out.println(JSON.toJSONString(u.a));
    }

    public class A{
        private Integer a = 7;
    }
}
