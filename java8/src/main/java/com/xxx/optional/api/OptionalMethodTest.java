//package com.xxx.optional.api;
//
//import com.alibaba.fastjson.JSON;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Optional;
//
//public class OptionalMethodTest {
//    public static void main(String[] args) {
//
//
//        //  场景： 用于避免处理空指针异常（NullPointerException)。
//        //  将可能为空值的变量放入Optional容器中，通过Optional容器访问对象.
//
//        //    创建Optional对象
//        // 1.1 声明一个空的Optional
//
//        Car car1 = new Car();
//        Optional<Insurance> insurance2 = Optional.empty();
//        Optional<Car> car = Optional.ofNullable(car1);
//        Person person =new Person();
//        person.setCarOptional(car);
//        car1.setInsuranceOptional(insurance2);
//
//        // 1.2 依据一个非空值创建
//        Optional<Person> person2 = Optional.of(person);
//        System.out.println(person2.get());
//
//
//        // 2
//
//        Optional<Integer> p = Optional.of(3);
//        Integer i = 3;
//
//        System.out.println(JSON.toJSONString(p));
//
//
//
//
//
//        System.out.println(getName(2).orElse("Unknown"));
//
//        Optional<Insurance> insurance = Optional.ofNullable(null);
//        Optional<String> name = insurance.map(Insurance::getName);
//        System.out.println(name.get());
//
//
//
//
//
//
//    }
//
//    public String getCarInsuranceName(Person person) {
//        if (person == null) {
//            return "Unknown";
//        }
//        Car car = person.getCar();
//        if (car == null) {
//            return "Unknown";
//        }
//        Insurance insurance = car.getInsurance();
//        if (insurance == null) {
//            return "Unknown";
//        }
//        return insurance.getName();
//    }
//
//
//    public String getCarInsuranceNameOptional(Optional<Person> person) {
//        return person.flatMap(Person::getCarOptional)
//            .flatMap(Car::getInsuranceOptional)
//            .map(Insurance::getName)
//            .orElse("Unknown");
////        return person.map(Person::getCarOptional).map()
////                .map(Car::getInsuranceOptional)
////                .map(Insurance::getName)
////                .orElse("Unknown");
//    }
//
//    protected  static  Optional<String> getName(Integer userId){
//        Map<Integer,String> userId4Name = new HashMap<>();
//        userId4Name.put(1,"jack");
//        userId4Name.put(2,"kate");
//        return Optional.ofNullable(userId4Name.get(userId));
//    }
//
//}
