package com.snailwu.designpattern.p22_memento_pattern;

/**
 * @author 吴庆龙
 * @date 2020/4/13 4:41 下午
 */
public class Caretaker {
    private Memento memento;

    public void setMemento(Memento m) {
        this.memento = m;
    }

    public Memento getMemento() {
        return memento;
    }
}
