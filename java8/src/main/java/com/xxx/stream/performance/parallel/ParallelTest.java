package com.xxx.stream.performance.parallel;

import com.google.common.collect.Lists;

import java.util.List;

public class ParallelTest {

    private final static Long size = 10000000L;
    public static void main(String[] args) {
        List<Long> list = Lists.newArrayList();
        for (long i = 0; i < size; i++) {
            list.add(i);
        }

        // 1 ；
        Long starTime = System.currentTimeMillis();
        Long sum = 0L;
        for (Long i : list) {
            sum +=i;
        }
        Long endTime1 = System.currentTimeMillis();
        System.out.println(sum+"forEach spend time :sum"+(endTime1-starTime));

        //2
        sum = 0L;
        sum = list.stream().reduce(0L,(x,y) -> x+y);
        Long endTime2 = System.currentTimeMillis();
        System.out.println(sum+"stream spend time"+(endTime2-endTime1));

        sum = 0L;
        sum = list.stream().reduce(0L,(x,y) -> x+y);
        Long endTime3 = System.currentTimeMillis();
        System.out.println(sum+"parallelStream spend time"+(endTime3-endTime2));


    }
}
