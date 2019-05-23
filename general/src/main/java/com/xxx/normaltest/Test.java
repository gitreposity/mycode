package com.xxx.normaltest;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Data;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

/**
 * a
 *
 * @author guodq
 * @create 2018-03-下午3:45
 */

public class Test {
    public static void main(String[] args) {
        List<A> list = Lists.newArrayList();
        A a  = new A();
        list.add(a);
        a.setCatIds(Lists.newArrayList(1,2));

        a  = new A();
        list.add(a);
        a.setCatIds(Lists.newArrayList(1,2,4,5));

        a  = new A();
        list.add(a);
        a.setCatIds(Lists.newArrayList());

        System.out.println(list.stream().flatMap(t -> t.getCatIds().stream()).collect(toList()));
    }

    @Data
    static  class  A {
        private Integer i;

        private List<Integer> catIds;

    }


}

class A{
    public static void main(String[] args) {
        Map<Integer,Integer> map =Maps.newHashMap();
        map.put(1,2);
        Map<Integer,Integer> map2 = Maps.newHashMap(map);
        map2.put(1,6);


    }
}
