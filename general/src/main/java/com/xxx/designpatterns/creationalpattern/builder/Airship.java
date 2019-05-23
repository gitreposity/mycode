package com.xxx.designpatterns.creationalpattern.builder;

import lombok.Data;

/**
 * 宇宙飞船
 *
 * @author guodq
 * @create 2018-09-下午12:06
 */

@Data
public class Airship {

    private Engine engine;

    private OrbitalModule orbitalModule;

    private EscapeTower escapeTower;
}

@Data
class Engine{
    private String name;

}

@Data
class EscapeTower{
    private String name;
}

@Data
class OrbitalModule{
    private String name;
}

