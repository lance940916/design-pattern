package com.snailwu.designpattern.p8_bridge_pattern;

/**
 * @author: 吴庆龙
 * @date: 2020/1/19 5:19 下午
 */
public class DrawSquareShape extends AbstractDrawShape {

    public DrawSquareShape(IColor color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("颜色为 " + color.name() + " 的正方形");
    }
}
