package com.xxx.lambda.methodreference;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * lambda 方法引用
 */
public class Test {

    // 方法引用：lambda表达式的语法糖。

    // 1:(args) -> ClassName.staticMethod(args)
    //  ClassName::staticMethod   //args 可以为空

    // 2:(arg0,rest) -> argo.instanceMethod(rest)
    // ClassName::instanceMethod    argo是ClassName类型的   //rest 可以为空

    // 3:(args)  -> expr.instanceMethod(args)
    // expr::instanceMethod    // args 可以为空

    public static void main(String[] args) {

//        List<String> str = Arrays.asList("a","b","A","B");
//
//        // 1
//        Function<String, Integer> stringToInteger = (String s) -> Integer.parseInt(s);
//        stringToInteger = Integer::parseInt;
//
//        // 2
//        Function<Student,String> f = s -> s.getName();
//        f = Student::getName;
//
//        // 2
//        BiFunction<String,Integer,String> biFunction = (s,i) -> s.substring(i);
//        biFunction = String::substring;
//
//        // 2
//        str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
//        str.sort(String::compareToIgnoreCase);
//
//        // 3
//        PrintStream p = System.out;
//        str.forEach(x -> p.println(x));
//        str.forEach(System.out::println);
//
//        // 3
//        Runnable r = () -> Thread.currentThread().getName();
//        r = Thread.currentThread()::getName;
//        Test test = new Test();
//        r = () -> test.test();


        //  构造函数的引用
        // ClassName::new

        //  空的构造函数
        Supplier<Student> studentSupplier = () -> new Student();
        studentSupplier = Student::new;
        System.out.println(studentSupplier.get());

        // 一个参数的构造函数
        Function<Integer,Student> function = (o) -> new Student(o);
        function =  Student::new;
        System.out.println(function.apply(3));

        // 二个参数的构造函数
        BiFunction<Integer,String,Student> biFunction1 = (o,s) -> new Student(o,s);
        biFunction1 = Student::new;
        System.out.println(biFunction1.apply(1,"fs"));

        // 大于两个自己定义
        TriFunction<Integer,String,Integer,Student> triFunction = Student::new;
        System.out.println(triFunction.apply(1,"fs",1));


    }

    @NoArgsConstructor
    @Data
    private static class Student{
        private Integer id;

        private String name;

        private Integer age;

        public Student(Integer id, String name, Integer age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public Student(Integer id) {
            this.id = id;
        }

        public Student(Integer id, String name) {
            this.id = id;
            this.name = name;
        }
    }



    void test(){
        System.out.println("hello");
    }
}


interface TriFunction<T, U, V, R>{
    R apply(T t, U u, V v);
}
