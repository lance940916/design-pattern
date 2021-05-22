package com.snailwu.designpattern.d19_mediator_pattern;

/**
 * @author 吴庆龙
 * @date 2020/4/1 10:16 上午
 */
public abstract class Mediator {
    public abstract void register(Colleague colleague);
    public abstract void relay(Colleague colleague);
}
