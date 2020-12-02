package com.snailwu.designpattern.p9_decorator_pattern;

/**
 * @author: 吴庆龙
 * @date: 2020/3/2 11:13 上午
 */
public abstract class Decorator implements Component {
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}
