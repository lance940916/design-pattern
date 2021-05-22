package com.snailwu.designpattern.d08_bridge_pattern;

/**
 * @author 吴庆龙
 * @date 2020/1/19 5:19 下午
 */
public class DrawRoundShape extends AbstractDrawShape {

    public DrawRoundShape(IColor color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("颜色为 " + color.name() + " 的圆形");
    }
}
