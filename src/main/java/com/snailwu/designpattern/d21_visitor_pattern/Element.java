package com.snailwu.designpattern.d21_visitor_pattern;

/**
 * @author 吴庆龙
 * @date 2020/4/10 11:45 上午
 */
public interface Element {
    void accept(Visitor visitor);
}
