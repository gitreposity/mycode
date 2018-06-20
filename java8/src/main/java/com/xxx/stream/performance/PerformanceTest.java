package com.xxx.stream.performance;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.IntStream;

public class PerformanceTest {
    private final static Integer size = 1000000;

    public static void main(String[] args) {

        List<Integer> ids = Lists.newArrayList();
        for (int i = 0; i < size; i++) {
            if (i > 500000)
                ids.add(i);
        }
//        ids.stream().forEach(System.out::println);
        IntStream.rangeClosed(1,size).filter(i -> i>500000).forEach(System.out::println);

    }
}
