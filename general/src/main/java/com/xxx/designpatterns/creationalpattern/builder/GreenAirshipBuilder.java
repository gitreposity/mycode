package com.xxx.designpatterns.creationalpattern.builder;

/**
 * 啊
 *
 * @author guodq
 * @create 2018-09-下午12:11
 */
public class GreenAirshipBuilder implements AirshipBuilder{


    @Override
    public Engine builderEngine() {
        System.out.println("builderEngine");
        return new Engine();
    }

    @Override
    public EscapeTower builderEscapeTower() {
        System.out.println("builderEscapeTower");
        return new EscapeTower();
    }

    @Override
    public OrbitalModule builderOrbitalModule() {
        System.out.println("builderOrbitalModule");
        return new OrbitalModule();
    }
}
