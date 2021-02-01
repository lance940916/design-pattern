package com.snailwu.design.d10_facade_pattern;

/**
 * 外观模式
 *
 * @author 吴庆龙
 * @date 2020/3/2 5:03 下午
 */
public class Client {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.f();
    }
}
