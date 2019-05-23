package com.xxx.localdate;

import com.xxx.designpatterns.creationalpattern.simplefactory.CarFactory;

import javax.xml.crypto.Data;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

/**
 * a
 *
 * @author guodq
 * @create 2018-08-15 下午1:11
 */

public class Test {

    public static void main(String[] args) {
//        Instant instant = Instant.now();
//        LocalTime localTime = LocalTime.now();
//        System.out.println(localTime);
//        System.out.println(instant);
//        LocalDateTime localDateTime = LocalDateTime.now();
//        System.out.println(localDateTime);
//        ZonedDateTime zonedDateTime = ZonedDateTime.now();
//        System.out.println(zonedDateTime);

//        LocalTime localTime = LocalTime.now();
//        localTime = localTime.plusHours(2);
//        System.out.println(localTime);

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        localDate = localDate.plus(2, ChronoUnit.WEEKS);
        System.out.println(localDate);

//        LocalTime localTime = LocalTime.now();
//        LocalTime  releaseLocalTime = LocalTime.of(10,24,56);
//        if(releaseLocalTime.isAfter(localTime)){
//            System.out.println(true);
//        }
        String saleTime = "23:00:01";
        LocalTime localTime = LocalTime.parse(saleTime, DateTimeFormatter.ISO_LOCAL_TIME);
//        LocalTime localTi2e2 =  LocalTime.of(0,0,0);
//        System.out.println(localTime);

        Date nowTime = new Date();
        Long l1 =  nowTime.getTime();
        System.out.println(l1);

        LocalDateTime localDateTime = LocalDateTime.now();
        Long l2 = localDateTime.atZone(ZoneId.systemDefault()).toEpochSecond();
        System.out.println(l2);




    }
}
