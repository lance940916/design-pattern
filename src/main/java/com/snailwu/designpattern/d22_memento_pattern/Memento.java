package com.snailwu.designpattern.d22_memento_pattern;

/**
 * @author 吴庆龙
 * @date 2020/4/13 4:40 下午
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
