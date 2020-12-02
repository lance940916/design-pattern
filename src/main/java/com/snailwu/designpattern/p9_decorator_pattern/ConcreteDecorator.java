package com.snailwu.designpattern.p9_decorator_pattern;

/**
 * @author: 吴庆龙
 * @date: 2020/3/2 11:21 上午
 */
public class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        doSomething();
    }

    private void doSomething() {
        System.out.println("do something");
    }
}
