package com.xxx.designpatterns.creationalpattern.builder;

/**
 * 啊
 *
 * @author guodq
 * @create 2018-09-下午12:11
 */
public interface AirshipBuilder {

    Engine builderEngine();

    EscapeTower builderEscapeTower();

    OrbitalModule builderOrbitalModule();
}
