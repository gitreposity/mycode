package com.xxx.test;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * aa
 *
 * @author guodq
 * @create 2018-13-下午5:09
 */

public class JsonTest {

    public static void main(String[] args) {
        List<A> list = Arrays.asList(new A(1, Collections.singletonList(null)));
        System.out.println(JSON.toJSONString(list));
    }

    @Data
    @AllArgsConstructor
    public static class A{
         private Integer id;

         List<B>  bs ;

        @Data
        @AllArgsConstructor
        public static class B{

            private Integer id;

            private String name;
        }
    }
}
