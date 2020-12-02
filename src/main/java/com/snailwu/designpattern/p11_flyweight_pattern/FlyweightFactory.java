package com.snailwu.designpattern.p11_flyweight_pattern;

import java.util.HashMap;

/**
 * @author: 吴庆龙
 * @date: 2020/3/3 3:02 下午
 */
public class FlyweightFactory {
    private HashMap<String, Flyweight> flyweightHashMap = new HashMap<>();

    public Flyweight getFlyweight(String key) {
        Flyweight flyweight = flyweightHashMap.get(key);
        if (flyweight != null) {
            System.out.println("具体享元：" + key + " 已经存在, 被成功获取");
        } else {
            flyweight = new ConcreteFlyweight(key);
            flyweightHashMap.put(key, flyweight);
        }
        return flyweight;
    }
}
