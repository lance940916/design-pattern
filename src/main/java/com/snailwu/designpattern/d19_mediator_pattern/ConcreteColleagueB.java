package com.snailwu.designpattern.d19_mediator_pattern;

/**
 * @author 吴庆龙
 * @date 2020/4/1 10:18 上午
 */
public class ConcreteColleagueB extends Colleague {
    @Override
    public void receive() {
        System.out.println("具体同事类 B 收到请求");
    }

    @Override
    public void send() {
        System.out.println("具体同事类 B 发出请求");
        mediator.relay(this);
    }
}
