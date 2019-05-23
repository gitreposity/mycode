package com.xxx.normaltest;

/**
 * 类加载顺序测试类
 *
 * @author guodq
 * @create 2018-10-23 上午10:59
 */

public class ClassLoaderTest {

    private TTTT aa = new TTTT();

    public static  String tt ;

    {
        tt = aa.uu;
    }

    static {
        new ClassLoaderTest();
    }
}

class TTTT{
    public String uu = "dd";
}
