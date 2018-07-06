package com.xxx.lambda.complexlambda;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections.bag.SynchronizedSortedBag;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 复合lambda表达式
 */
public class ComplexLambda {

    public static void main(String[] args) {


        // 比较链1(包含)
        List<Student> students = Lists.newArrayList(new Student(1,"uu"),new Student(2,"afg"),new Student(2,"fddd"));
//        Collections.sort(students,Comparator.comparing((Student s) -> s.getName().length()).reversed());
//        students.forEach(System.out::println);
//        students.sort(Comparator.comparing(o -> o.getName()));


        Iterator<Student>  iterator = students.iterator();
        iterator.forEachRemaining(t -> System.out.println(t));
        //iterator.
        students.removeIf(o -> o.getName().equals("3"));

        Collection<Student> a = new LinkedList<>();
        a.add(new Student(1,"22"));
        a.removeIf(o -> o.getName().equals("22"));
//        students.forEach();

        //


    }

    @Data
    @NoArgsConstructor
    public static class Student{

        private Integer id;

        private String name;

        public Student(Integer id, String name) {
            this.id = id;
            this.name = name;
        }
    }

}


class PredicateLambda{
    public static void main(String[] args) {

//     List<String> strings = Lists.newArrayList("a","b","c");
//     strings.stream().filter(a -> a.equals(a));
        Predicate<String> a = s -> s.equals("a");
        Function<String,Integer> tttt = u -> Integer.valueOf(u);
        a.negate();
        List<String> strings = Lists.newArrayList("a","b","c");
        strings.stream().filter(a).forEach(System.out::println);
        System.out.println("-------------");
//        strings.stream().filter(a.or()).forEach(System.out::println);
    }
}

class FunctionCombination{
    public static void main(String[] args) {
        Function<Integer,Integer> f = x -> x+1;
        Function<Integer,Integer> g = x -> x *2;
        Function<Integer,Integer> c = f.andThen(g);
        System.out.println(c.apply(9));// (x+1) *2   = 20
        c = f.compose(g);
        System.out.println(c.apply(9));// x*2 +1 = 19
    }


}
