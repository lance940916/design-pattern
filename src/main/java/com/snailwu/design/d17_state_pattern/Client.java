package com.snailwu.design.d17_state_pattern;

/**
 * 状态模式
 *
 * @author 吴庆龙
 * @date 2020/3/19 10:35 上午
 */
public class Client {
    public static void main(String[] args) {
        // 默认状态 A
        Context context = new Context();
        context.handle();

        context.setState(new ConcreteStateB());
        context.handle();

    }
}
