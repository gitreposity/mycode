package com.xxx.designpatterns.creationalpattern.builder;

/**
 * 啊
 *
 * @author guodq
 * @create 2018-09-上午11:57
 */

public class Client {

    public static void main(String[] args) {
        GreenAirshipDirector greenAirshipDirector  = new GreenAirshipDirector(new GreenAirshipBuilder());
        Airship airship =  greenAirshipDirector.directorAirship();
    }
}
