package com.snailwu.designpattern.d17_state_pattern;

/**
 * @author 吴庆龙
 * @date 2020/3/19 10:10 上午
 */
public class Context {
    private State state;

    public Context() {
        this.state = new ConcreteStateA();
    }

    // 重新设置状态
    public void setState(State state) {
        this.state = state;
    }

    // 获取当前状态
    public State getState() {
        return state;
    }

    public void handle() {
        state.handle(this);
    }
}
