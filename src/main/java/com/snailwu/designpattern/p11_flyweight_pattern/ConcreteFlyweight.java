package com.snailwu.designpattern.p11_flyweight_pattern;

/**
 * 具体享元角色
 * @author: 吴庆龙
 * @date: 2020/3/3 3:00 下午
 */
public class ConcreteFlyweight implements Flyweight {
    // 共享的
    private String key;

    public ConcreteFlyweight(String key) {
        this.key = key;
        System.out.println("具体享元：" + key + " 被创建");
    }

    @Override
    public void operation(UnsharedConcreteFlyweight flyweight) {
        System.out.println("具体享元：" + key + "被调用，非享元信息是：" + flyweight.getInfo());
    }
}
