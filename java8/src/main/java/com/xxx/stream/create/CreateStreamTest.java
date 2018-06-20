package com.xxx.stream.create;

import java.util.Arrays;
import java.util.List;

public class CreateStreamTest {

    public static void main(String[] args) {

        // 1:创建流
        // 1.1 stream
//        Stream.of(3).forEach(System.out::print);

//        Stream.empty().forEach(System.out::println);

        // 1.2 无限流
//        Stream.iterate(1, n -> n + 1).limit(4).forEach(System.out::println);

//        Stream.generate(() -> "66767").limit(10).forEach(System.out::println);
//        // 12345
//
//        // 1.2 数值流
//        LongStream.range(0,10).forEach(System.out::println);
//
//        LongStream.rangeClosed(0,10).forEach(System.out::println);

//        DoubleStream d = Stream.of(3).mapToDouble(Double::valueOf);
//        //d.forEach(System.out::println);
//        Stream<Double> u = d.boxed();

//        // 1.3 数组和集合
        List<Integer> ids = Arrays.asList(1,2,3,4,5);
//        ids.stream().forEach(System.out::println);

//        int [] arrays = {1,2,3,4,5};
//        Arrays.stream(arrays).forEach(System.out::println);
//
//
//        // 流只可以执行一次终端操作
//        LongStream a = LongStream.rangeClosed(1,10);
//        a.forEach(System.out::println);
//        System.out.println(a.count());
//
//        // 流的懒加载
//        Stream.iterate(1, n -> n + 1).limit(10).map(integer -> {
//            System.out.println("流的懒加载");
//            return integer;
//        }).forEach(System.out::println);
//
         List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//        Stream<Integer> stream = numbers.stream().map(n -> n / 0).filter(n -> n % 2 == 0);
//
//        // 内外迭代
//        // 并发
//        numbers.stream().forEach(s -> System.out.println(s+Thread.currentThread().getName()));
//        numbers.parallelStream().forEach(s -> System.out.println(s+Thread.currentThread().getName()))

    }
}
