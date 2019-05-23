package com.xxx.test;

import com.google.common.collect.Maps;

import java.util.Map;

public class NormalTest {

    public static void main(String[] args) {


        Map<Integer,Map<Integer,String>> map = Maps.newHashMap();
        map.put(1,Maps.newHashMap());
        Map<Integer,String> otherMap = map.get(1);
        otherMap.put(1,"2");
        otherMap.put(3,"7");
        System.out.println(map);
    }
}
