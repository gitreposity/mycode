package com.xxx.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class BaseTest {

}

/**
 * 在lambda表达式中只可以使用final成员变量
 * 对成员变量或者（实例变量，静态变量）没有限制
 */
class ClosureTest{
    private int a = 9;

    public static void main(String[] args) {
        ClosureTest closureTest = new ClosureTest();
        Supplier<String> stringSupplier =  closureTest.getSupplier();
        System.out.println(stringSupplier.get());
    }

    Supplier<String> getSupplier(){
        Integer a = 7;
        System.out.println("方法开始");
        Supplier<String> stringSupplier = () -> {
            System.out.println();
            return "sss"+a;};
//        a = 8;
        return stringSupplier;
    }
}

/**
 * 返回void的兼容
 * lambda标签中，如果返回值是void情况下，但是函数只有一个语句可以兼容
 */
class VoidTest{
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Consumer<String> consumer = t -> list.add(t);
        consumer.accept("u");
        System.out.println(list.get(0));
    }
}