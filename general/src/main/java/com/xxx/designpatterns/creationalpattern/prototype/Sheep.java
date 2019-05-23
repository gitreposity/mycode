package com.xxx.designpatterns.creationalpattern.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 羊
 *
 * @author guodq
 * @create 2018-09-下午2:46
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sheep  implements Cloneable{

    private String name;

    private Date date;


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
