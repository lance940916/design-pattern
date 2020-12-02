package com.snailwu.designpattern.principle.single;

import java.util.Objects;

/**
 * @author: 吴庆龙
 * @date: 2020/1/8 10:50 上午
 */
public class Animal {

    public void breathe(String animal) {
        if (Objects.equals("鱼", animal)) {
            System.out.println(animal + "呼吸水");
        } else {
            System.out.println(animal + "呼吸空气");
        }

    }

}
