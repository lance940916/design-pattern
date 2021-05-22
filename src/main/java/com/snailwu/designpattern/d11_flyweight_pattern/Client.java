package com.snailwu.designpattern.d11_flyweight_pattern;

/**
 * 享元模式
 *
 * @author 吴庆龙
 * @date 2020/3/3 3:05 下午
 */
public class Client {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();

        // key 对应的实例只有一个
        Flyweight f01 = factory.getFlyweight("a");
        Flyweight f02 = factory.getFlyweight("a");
        Flyweight f03 = factory.getFlyweight("a");
        Flyweight f11 = factory.getFlyweight("b");
        Flyweight f12 = factory.getFlyweight("b");

        // 实例调用多次
        f01.operation(new UnsharedConcreteFlyweight("第1次调用a"));
        f02.operation(new UnsharedConcreteFlyweight("第2次调用a"));
        f03.operation(new UnsharedConcreteFlyweight("第3次调用a"));
        f11.operation(new UnsharedConcreteFlyweight("第1次调用b"));
        f12.operation(new UnsharedConcreteFlyweight("第2次调用b"));
    }
}
