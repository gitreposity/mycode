package com.xxx.designpatterns.structuralpattern.adapter.v2;

/**
 * 计算目标函数
 *
 * @author guodq
 * @create 2018-10-19 下午5:34
 */
public interface CalTarget {

    /**
     * 客户要求我输入三个数字计算其和
     */
    Integer calSum(Integer a,Integer b);
}
