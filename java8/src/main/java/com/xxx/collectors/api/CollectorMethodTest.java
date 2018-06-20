package com.xxx.collectors.api;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorMethodTest {
    public static void main(String[] args) {
        List<User> stus = Arrays.asList(new User(1,"jack",11,"男","湖南"),
                new User(2,"jack",16,"女","湖北"),
                new User(3,"jack1",19,"男","湖北"),
                new User(4,"jack2",17,"女","江西"),
                new User(5,"jack3",11,"男","浙江"));

        //  流的终端操作
        // 流的终端操作 forEach
        stus.forEach(System.out::println);

        // count
        Stream<User> stream = Stream.empty();
        Long l = stream.count(); //统计数量
        //System.out.println(l);
        // find
//        optional<User> u = stream.findFirst(); // 找第一个
//        optional<User> d = stream.findAny(); // 随机找一个
//        Boolean e = stream.allMatch(user -> user.getAge()>11); // 是否全部满足条件
//        Boolean f = stream.noneMatch(user -> user.getAge()>11); // 全部不满足条件
//        Boolean g = stream.anyMatch(user -> user.getAge()>11); // 有一个满座条件

        // collect

        // Collectors类
        // collectors.toMap
//        Map<Integer,String> map = new HashMap<>();
//        map = stus.stream().collect(collectors.toMap(User::getUserId,User::getName));
//        map = stus.stream().collect(collectors.toMap(User::getUserId,User::getName,(a,b) ->b));
//        Map<Integer,User>  map2 = stus.stream().collect(collectors.toMap(User::getUserId, user -> user));

//        Map<Integer,User> map3 = new LinkedHashMap<Integer,User>();
//        map3 = stus.stream().collect(collectors.toMap(User::getUserId,Function.identity(),(a,b) ->b ,LinkedHashMap::new));
//        map.forEach((id,name) -> System.out.println(id+":"+name));

        // collectors.toCollection
//        stus.stream().collect(collectors.toCollection(LinkedHashSet::new));

        // Comparator.maxBy  Comparator.minBy  获取id最大这个人的名字
        String name = stus.stream().collect(Collectors.minBy(Comparator.comparing(User::getUserId).reversed())).orElse(new User()).getName();
        //name = stus.stream().collect(collectors.minBy(Integer::compare).orElse(new User()).getName());
        System.out.println(name);

        // Comparator.mapping 获取所有人的id
//        List<Integer> strings = stus.stream().collect(collectors.mapping(User::getUserId,collectors.toList()));
//        strings.forEach(s -> System.out.println(s));

        // 找出不同地区的总人数  Comparator.groupingBy
        Map<String,Long> city4CountNumMap = stus.stream().collect(Collectors.groupingBy(User::getCity,Collectors.counting()));
//        city4CountNumMap.forEach((city,num) -> System.out.println(city+":"+num));

        // averagingDouble  找出不同地区的平均年龄
        Map<String,Double> city4AgeMap = stus.stream().collect(Collectors.groupingBy(User::getCity,Collectors.averagingDouble(User::getAge)));
        city4AgeMap.forEach((city,avgAge) -> System.out.println(city+":"+avgAge));

        // summingLong 找出不同地区的总年龄
//        Map<String,Long> city4allMap = stus.stream().collect(collectors.groupingBy(User::getCity,collectors.summingLong(User::getAge)));
//        city4allMap.forEach((city,avgAge) -> System.out.println(city+":"+avgAge));

        // 找出不同地区的最大年龄
//        Map<String,Optional<Integer>> city4AgeMap2 = stus.stream().collect(collectors.groupingBy(User::getCity,
//                collectors.mapping(User::getAge,collectors.maxBy(Integer::compare))));
//        city4AgeMap2.forEach((city,maxAvgOpl) -> System.out.println(city+":"+maxAvgOpl.orElse(0)));

//        Map<String,optional<User>> city4AgeMap2 = stus.stream().collect(collectors.groupingBy(User::getCity,
//                collectors.mapping(User::getAge,collectors.maxBy(Integer::compare))));
//        city4AgeMap2.forEach((city,maxAvgOpl) -> System.out.println(city+":"+maxAvgOpl.orElse(0)));

        // Comparator.去掉Optional
//        Map<String,Integer> city4AgeMap4 = stus.stream().collect(collectors.groupingBy(User::getCity,
//                collectors.mapping(User::getAge,collectors.collectingAndThen(collectors.maxBy(Integer::compare),Optional::get))));
//        city4AgeMap4.forEach((city,maxAvg) -> System.out.println(city+":"+maxAvg));

//        // 按照地区和年龄分组
        Map<String,Map<Integer,List<User>>> newMap  = stus.stream().collect(Collectors.groupingBy(User::getCity,Collectors.groupingBy(User::getAge)));
        newMap.forEach((city,groupMap) -> System.out.println(city+":"+ JSON.toJSONString(groupMap)));

        // Comparator.summarizingInt  // 统计除了浙江外其他地区的所有人的 平均年龄，最大平均年龄，最小平均年龄，总值平均年龄
        IntSummaryStatistics idStats = stus
                .stream().filter(user -> !user.getCity().equals("浙江"))
                .collect(Collectors.summarizingInt(User::getAge));
        System.out.println(idStats);






    }

    public static  class  User{
        private Integer userId;

        private String name;

        private Integer age;

        private String sex;

        private String city;


        public User(Integer userId, String name, Integer age, String sex, String city) {
            this.userId = userId;
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.city = city;
        }

        public User() {
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }


}
