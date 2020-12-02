package com.snailwu.designpattern.p22_memento_pattern;

/**
 * @author 吴庆龙
 * @date 2020/4/13 4:40 下午
 */
public class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento createMemento() {
        return new Memento(state);
    }

    public void restoreMemento(Memento m) {
        this.setState(m.getState());
    }
}
