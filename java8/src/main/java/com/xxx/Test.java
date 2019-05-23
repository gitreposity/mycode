package com.xxx;

import java.math.BigDecimal;

/**
 * 测试类
 *
 * @author guodq
 * @create 2018  03 下午3:57
 */
public class Test {
    public static void main(String[] args) {
        Double d = 61.00;
        Long l = 5299L;
        System.out.println(new BigDecimal(l).divide(new BigDecimal(d.toString()),0,BigDecimal.ROUND_HALF_UP).longValue());
    }
}
