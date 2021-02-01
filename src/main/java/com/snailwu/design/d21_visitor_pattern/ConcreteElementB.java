package com.snailwu.design.d21_visitor_pattern;

/**
 * @author 吴庆龙
 * @date 2020/4/10 11:46 上午
 */
public class ConcreteElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operationB() {
        return "具体元素 B";
    }
}
