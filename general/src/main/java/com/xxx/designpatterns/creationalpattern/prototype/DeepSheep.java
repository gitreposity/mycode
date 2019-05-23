package com.xxx.designpatterns.creationalpattern.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * d
 *
 * @author guodq
 * @create 2018-09-下午3:20
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeepSheep implements Cloneable{

    private String name;

    private Date date;


    @Override
    protected Object clone() throws CloneNotSupportedException {
        DeepSheep sheep = (DeepSheep) super.clone();
        sheep.setDate((Date)this.date.clone());
        return sheep;
    }
}
