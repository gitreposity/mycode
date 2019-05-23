package com.xxx.datatype;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * 浮点数字的运算
 *
 * @author guodq
 * @create 2018-03-下午12:01
 */

public class BigDecimal {

    public static void main(String[] args) {
        double a = 1.01;
        double b = 2.01;
//        System.out.println(a+b);
        // 输出 3.0199999999999996
        A aaa = new A();
        System.out.println(JSON.toJSONString(aaa));
    }

    @Data
    public static class A{
        private Integer i;

        private String b;
    }



}
