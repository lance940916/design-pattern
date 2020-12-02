package com.snailwu.designpattern.p12_composite_pattern.pattern2;

/**
 * @author: 吴庆龙
 * @date: 2020/3/6 10:18 上午
 */
public abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract String name();
}
