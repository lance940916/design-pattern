package com.snailwu.design.d19_mediator_pattern;

/**
 * 状态模式
 *
 * @author 吴庆龙
 * @date 2020/4/1 10:22 上午
 */
public class Client {
    public static void main(String[] args) {
        Mediator m = new ConcreteMediator();
        Colleague cA = new ConcreteColleagueA();
        Colleague cB = new ConcreteColleagueB();

        m.register(cA);
        m.register(cB);

        cA.send();
        System.out.println("-----分割线");
        cB.send();
    }
}
