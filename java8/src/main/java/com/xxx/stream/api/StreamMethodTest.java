package com.xxx.stream.api;


import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class StreamMethodTest {

    public static void main(String[] args) {

        List<Student> stus = Lists.newArrayList(new Student(1,"jack"),
                new Student(2,"tom"),new Student(3,"kate"));

        //过渡操作
        //  过渡操作   过渡操作
        // filter   找出id>=2 的学生
        stus.stream().filter(stu -> stu.getId()>=2).forEach(s -> System.out.println(JSON.toJSONString(s)));

        // map 找出id>=2 的学生名字
        stus.stream().filter(stu -> stu.getId()>=2).map(Student::getName).forEach(System.out::println);

        // peek  给学生加入游戏
        stus.stream().peek(stu -> stu.setGames(Lists.newArrayList("LOL","DOTA"))).forEach(s -> System.out.println(JSON.toJSONString(s)));

        List<Student> newStuList = stus.stream().peek(stu -> {
            if (stu.getId().equals(1)) {
                stu.setGames(Arrays.asList("LOL", "DOTA", "CF"));
            } else {
                stu.setGames(Collections.singletonList("CS"));
            }
        }).collect(toList());
        //newStuList.forEach(s -> System.out.println(JSON.toJSONString(s)));


        // flatMap   扁平化    每个游戏有哪些学生玩
        List<String> strings = Lists.newArrayList("sfsfdf","fffdd","fff");
        Stream<String[]> streamArrays = strings.stream().map(o -> o.split(""));
        Stream<String> stringStream = streamArrays.flatMap(a -> Arrays.stream(a));
        stringStream.forEach(System.out::println);


        // 每种游戏有那些同学玩
        Stream<TempStu> tempStuStream = newStuList.stream().flatMap(stu -> stu.getGames().stream().
                map(game -> new TempStu(stu.getId(),stu.getName(),game)));
//        tempStuStream.forEach(s -> System.out.println(JSON.toJSONString(s)));
        Map<String,List<String>> game4NamesMap = tempStuStream.collect(groupingBy(TempStu::getGame,mapping(TempStu::getName,toList())));


        // limit 截取多少条
        newStuList.stream().limit(1).forEach(s -> System.out.println(JSON.toJSONString(s)));

        // skip 跳过多少条
        newStuList.stream().skip(1).forEach(s -> System.out.println(JSON.toJSONString(s)));

        // limit+skip 内存分页
//        Integer pageSise = 1;
//        Integer currPage = 1;
//        newStuList.stream().skip((currPage-1)*pageSise).limit(pageSise).forEach(s -> System.out.println(JSON.toJSONString(s)));

        // sorted 按id 降序，在按照游戏多少升序
        newStuList.stream().sorted(comparing(Student::getId).reversed().thenComparing((Student stu)->stu.getGames().size()));
//                .forEach(s -> System.out.println(JSON.toJSONString(s)));

        // reduce 规约
        List<Integer> numbers = Arrays.asList(1,2,1);
        String names = "";
//        names = newStuList.stream().map(Stu::getName).reduce((a,b) ->a+b).orElse("没有名字");
//        System.out.println("names:"+names);

//        names = newStuList.stream().map(Stu::getName).reduce("我们的名字是",(a,b) ->a+b+",");
//        System.out.println("names:"+names);

//        Integer sum = numbers.stream().reduce(0,(a,b) -> {
//            System.out.println("a:"+a+"b:"+b) ;return (a*a+b*b);});
//        System.out.println("sum:"+sum);

        // distinct  去重
//        numbers.stream().distinct().forEach(System.out::println);


        // iterate
//        LongStream.iterate(1, el -> el + 1).filter(el -> el % 2 == 0).limit(50).forEach(s -> System.out.println(Thread.currentThread().getName()));
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Student{
        private Integer id;

        private String name;


        private List<String> games;

        public Student(Integer id, String name) {
            this.id = id;
            this.name = name;
        }


    }


    @NoArgsConstructor
    @Data
    private static class TempStu{
        private Integer id;

        private String name;

        private String game;

        public TempStu(Integer id, String name, String game) {
            this.id = id;
            this.name = name;
            this.game = game;
        }
    }


    static class Temp{

        public static void main(String[] args) {
            List<Student> stus = Lists.newArrayList(new Student(1,"jack",Arrays.asList("dddd","ttt")),
                    new Student(2,"tom",Collections.singletonList(null)));
            stus.stream().flatMap(t -> t.getGames().stream().map(u -> new TempStu(t.getId(),t.getName(),u))).forEach(System.out::println);
        }

    }
}
