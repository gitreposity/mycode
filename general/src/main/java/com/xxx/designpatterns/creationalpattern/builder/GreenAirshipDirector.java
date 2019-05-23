package com.xxx.designpatterns.creationalpattern.builder;

/**
 * a
 *
 * @author guodq
 * @create 2018-09-下午12:25
 */

public class GreenAirshipDirector implements AirshipDirector{

    private AirshipBuilder airshipBuilder;

    public GreenAirshipDirector(AirshipBuilder airshipBuilder) {
        this.airshipBuilder = airshipBuilder;
    }

    @Override
    public Airship directorAirship() {
        Airship airship = new Airship();
        airship.setEngine(airshipBuilder.builderEngine());
        airship.setEscapeTower(airshipBuilder.builderEscapeTower());
        airship.setOrbitalModule(airshipBuilder.builderOrbitalModule());
        return airship;
    }
}
