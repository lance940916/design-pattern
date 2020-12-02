package com.snailwu.designpattern.p8_bridge_pattern;

/**
 * @author: 吴庆龙
 * @date: 2020/1/19 5:13 下午
 */
public abstract class AbstractDrawShape {

    protected IColor color;

    public AbstractDrawShape(IColor color) {
        this.color = color;
    }

    public abstract void draw();

}
