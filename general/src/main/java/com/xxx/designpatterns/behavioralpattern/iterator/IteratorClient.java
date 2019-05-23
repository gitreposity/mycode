package com.xxx.designpatterns.behavioralpattern.iterator;


import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.*;
import java.util.function.Consumer;

/**
 * IteratorClient
 *
 * @author guodq
 * @create 2018-10-19 下午2:36
 */

public class IteratorClient {
    public static void main(String[] args) {

        // 1.不使用迭代遍历
        List<Integer> listCollection = Lists.newArrayList();
        listCollection = Lists.newLinkedList();
        for (int i = 0; i < listCollection.size(); i++) {
            System.out.println(listCollection.get(i));
        }
        Set<Integer> setCollection = Sets.newHashSet();
        for (int i = 0; i < setCollection.size(); i++) {
            // 不可以直接get获取数据
//            System.out.println(setCollection.get(i));
        }

        // 2.使用迭代器遍历
        Iterator iterator = null;
        // 2.1  遍历list
        iterator = listCollection.iterator();
        while (null != iterator && iterator.hasNext()){
            System.out.println(iterator.next());
        }
        // 2.2 遍历set
        iterator = setCollection.iterator();
        while (null != iterator && iterator.hasNext()){
            System.out.println(iterator.next());
        }

        for (Integer i : listCollection){
            System.out.println(i);
        }
    }
}
