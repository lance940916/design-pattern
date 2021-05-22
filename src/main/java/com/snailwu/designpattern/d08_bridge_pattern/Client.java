package com.snailwu.designpattern.d08_bridge_pattern;

/**
 * 桥接模式
 *
 * @author 吴庆龙
 * @date 2020/1/19 5:21 下午
 */
public class Client {
    public static void main(String[] args) {
        AbstractDrawShape squareShape = new DrawSquareShape(new YellowColor());
        squareShape.draw();

        AbstractDrawShape roundShape = new DrawRoundShape(new OrangeColor());
        roundShape.draw();
    }
}
