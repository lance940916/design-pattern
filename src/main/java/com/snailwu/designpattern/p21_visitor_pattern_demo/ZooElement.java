package com.snailwu.designpattern.p21_visitor_pattern_demo;

/**
 * @author 吴庆龙
 * @date 2020/4/13 10:37 上午
 */
public class ZooElement implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
