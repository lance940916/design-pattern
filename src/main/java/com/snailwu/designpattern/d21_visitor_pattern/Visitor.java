package com.snailwu.designpattern.d21_visitor_pattern;

/**
 * @author 吴庆龙
 * @date 2020/4/10 11:43 上午
 */
public interface Visitor {
    void visit(ConcreteElementA elementA);
    void visit(ConcreteElementB elementB);
}
