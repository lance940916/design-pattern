package com.snailwu.designpattern.d19_mediator_pattern;

/**
 * @author 吴庆龙
 * @date 2020/4/1 10:17 上午
 */
public abstract class Colleague {
    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void receive();
    public abstract void send();
}
