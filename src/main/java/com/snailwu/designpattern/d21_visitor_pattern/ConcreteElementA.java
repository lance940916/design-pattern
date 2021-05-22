package com.snailwu.designpattern.d21_visitor_pattern;

/**
 * @author 吴庆龙
 * @date 2020/4/10 11:45 上午
 */
public class ConcreteElementA implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operationA() {
        return "具体元素 A";
    }
}
