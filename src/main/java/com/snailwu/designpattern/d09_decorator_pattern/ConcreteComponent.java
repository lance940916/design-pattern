package com.snailwu.designpattern.d09_decorator_pattern;

/**
 * @author 吴庆龙
 * @date 2020/3/2 11:13 上午
 */
public class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("ConcreteComponent operation");
    }
}
