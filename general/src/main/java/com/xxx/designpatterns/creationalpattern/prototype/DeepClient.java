package com.xxx.designpatterns.creationalpattern.prototype;

import java.util.Date;

/**
 * kehu
 *
 * @author guodq
 * @create 2018-09-下午2:40
 */

public class DeepClient {

    public static void main(String[] args) throws Exception{
        Date date = new Date();
        DeepSheep sheep = new DeepSheep("dd",date);
        DeepSheep sheep2 = (DeepSheep) sheep.clone();
        date.setTime(456666666L);
        System.out.println(sheep2);
        System.out.println(sheep);
    }
}
