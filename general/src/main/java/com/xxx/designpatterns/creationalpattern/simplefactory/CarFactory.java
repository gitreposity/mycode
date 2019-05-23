package com.xxx.designpatterns.creationalpattern.simplefactory;

/**
 * 生产车
 *
 * @author guodq
 * @create 2018-06-下午5:45
 */

public class CarFactory {
    /**
     * @Description: 根据车的名字生产车
     * 
     * @Author: guodq
     *
     * @Date:  下午5:48 18/7/6
     * 
     * @version:  1.0
     *
     */
    public static Car createCar(String carName){
        if (carName.equals("Ferrari"))
            return new Ferrari();
        else if (carName.equals("Tesla"))
            return new Tesla();
        else return null;
    }



    public static Car createFerrari(){
        return new Ferrari();
    }

    public static Car createTesla(){
        return new Tesla();
    }
}
