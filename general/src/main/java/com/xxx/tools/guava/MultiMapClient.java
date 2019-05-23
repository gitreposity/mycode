package com.xxx.tools.guava;


import com.google.common.collect.*;
import com.sun.tools.javac.code.Kinds;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * MultiMap
 *
 * @author guodq
 * @create 2018-08-07 下午3:07
 */

public class MultiMapClient {

    public static void main(String[] args) {
        // ListMultimap
        ListMultimap<String,Integer> listMultimap = ArrayListMultimap.create();
        listMultimap.put("你好",3);
        listMultimap.put("你好",2);
        listMultimap.put("你好",1);
        listMultimap.put("你好2",1);
        listMultimap.put(null,4);
        System.out.println(listMultimap.size());
        System.out.println(listMultimap.keySet());
        System.out.println();
        System.out.println(listMultimap);


        SetMultimap<String,String> setMultimap = HashMultimap.create();
        setMultimap.put("1","1");
        setMultimap.put("1","1");
        setMultimap.put("12","2");
        setMultimap.put("12","3");
        setMultimap.put("1","1");
        setMultimap.put("1","1");
        setMultimap.put(null,"1");
        System.out.println(setMultimap);
//        Map<String,Set<String>> yy = (Map<String,Set<String>>) setMultimap.asMap();
//        System.out.println(yy);


        List<Integer> list = Lists.newArrayList(1,2,3,3,5,5,6);
        Map<Integer,List<Integer>> tt = list.stream().collect(Collectors.groupingBy(Function.identity()));
        System.out.println(tt);




    }
}
