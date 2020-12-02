package com.snailwu.designpattern.p21_visitor_pattern_demo;

/**
 * @author 吴庆龙
 * @date 2020/4/13 10:35 上午
 */
public interface Element {
    void accept(Visitor visitor);
}
