package com.snailwu.designpattern.p9_decorator_pattern;

/**
 * @author: 吴庆龙
 * @date: 2020/3/2 11:22 上午
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("未装饰前：");
        Component component = new ConcreteComponent();
        component.operation();

        System.out.println("装饰后：");
        Decorator decorator = new ConcreteDecorator(component);
        decorator.operation();

        // 也可以写为
        Component decoratorComponent = new ConcreteDecorator(component);
        decoratorComponent.operation();
    }
}
