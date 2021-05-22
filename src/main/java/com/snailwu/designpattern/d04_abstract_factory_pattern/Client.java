package com.snailwu.designpattern.d04_abstract_factory_pattern;

/**
 * 抽象工厂模式
 *
 * @author 吴庆龙
 * @date 2020/2/10 4:44 下午
 */
public class Client {
    public static void main(String[] args) {
        AbstractFactory factory = new HuaWeiFactory();
        AbstractMobile mobile = factory.createMobile();
        System.out.println(mobile.name());
        AbstractTV tv = factory.createTV();
        System.out.println(tv.name());
    }
}
