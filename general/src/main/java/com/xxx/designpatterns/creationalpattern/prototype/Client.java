package com.xxx.designpatterns.creationalpattern.prototype;

import java.util.Date;

/**
 * kehu
 *
 * @author guodq
 * @create 2018-09-下午2:40
 */

public class Client{

    public static void main(String[] args) throws Exception{
        Date date = new Date();
        Sheep sheep = new Sheep("aaa",date);
        Sheep sheep2 = (Sheep) sheep.clone();
        sheep.setName("dddd");
        System.out.println(sheep2);

//        Sheep sheep3 = sheep;
    }
}
