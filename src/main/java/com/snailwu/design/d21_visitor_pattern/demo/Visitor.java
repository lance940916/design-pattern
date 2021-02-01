package com.snailwu.design.d21_visitor_pattern.demo;

/**
 * @author 吴庆龙
 * @date 2020/4/13 10:36 上午
 */
public interface Visitor {
    void visit(ZooElement zooElement);
    void visit(ParkElement parkElement);
}
