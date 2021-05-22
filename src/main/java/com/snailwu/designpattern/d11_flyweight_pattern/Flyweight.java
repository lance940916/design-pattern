package com.snailwu.designpattern.d11_flyweight_pattern;

/**
 * 抽象享元角色
 *
 * @author 吴庆龙
 * @date 2020/3/3 2:59 下午
 */
public interface Flyweight {
    void operation(UnsharedConcreteFlyweight flyweight);
}
