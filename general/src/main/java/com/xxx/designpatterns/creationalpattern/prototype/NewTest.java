package com.xxx.designpatterns.creationalpattern.prototype;

import lombok.Data;

import java.util.Date;

/**
 * a
 *
 * @author guodq
 * @create 2018-11-08 下午5:13
 */

public class NewTest {

    @Data
    public static class  UU{
        private Integer i;

        private Date date;
    }

    public static void main(String[] args) {
        UU uu = new UU();
        uu.setI(6);
        UU dd = uu;
        dd.setI(7);
        System.out.println("uu:"+uu);
        System.out.println("dd:"+uu);
        System.out.println(uu.equals(dd));



    }
}
