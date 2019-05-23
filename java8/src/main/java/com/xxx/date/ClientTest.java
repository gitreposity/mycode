package com.xxx.date;

import java.time.*;

/**
 * 常用用法测试
 *
 * @author guodq
 * @create 2018-08-27 上午10:52
 */

public class ClientTest {
    public static void main(String[] args) {
        // LocalData
        LocalDate localDate = LocalDate.now();

        // 查看区时
        ZoneId zoneId = ZoneId.systemDefault();
        Instant.now().toEpochMilli();
        System.out.println(ZoneId.getAvailableZoneIds());

        Clock clock = Clock.system(ZoneId.of("Asia/Shanghai"));
        System.out.println(clock.instant());
    }
}
