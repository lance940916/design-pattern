package com.snailwu.designpattern.p13_template_method_pattern;

/**
 * @author: 吴庆龙
 * @date: 2020/3/9 10:22 上午
 */
public class Client {
    public static void main(String[] args) {
        AbstractClass ac = new ConcreteClass();
        ac.oneDay();
    }
}
