package com.xxx.stream;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class BaseTest {

    private static int a= 7;

    public static void main(String[] args) {
        List<String>  aa =  Lists.newArrayList("b","c");
        System.out.println("bbbb");
        Student student = new Student();
        test(student);
        System.out.println(a);

    }

    static void  test(Student student){
        Integer a = 7;
        student.setId(7);
        System.out.println("bb");
    }

    @Data
    @NoArgsConstructor
    public static class Student{
        private Integer id;
    }

}
