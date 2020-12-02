package com.snailwu.designpattern.p16_chain_of_responsibility_pattern;

/**
 * @author: 吴庆龙
 * @date: 2020/3/16 10:17 上午
 */
public class Client {
    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        handler1.setNext(handler2);

        handler1.handleRequest("one");
    }
}
