package com.snailwu.designpattern.d17_state_pattern;

/**
 * @author 吴庆龙
 * @date 2020/3/19 10:33 上午
 */
public class ConcreteStateA extends State {
    @Override
    public void handle(Context context) {
        System.out.println("状态 A");
        context.setState(new ConcreteStateB());
    }
}
