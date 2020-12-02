package com.snailwu.designpattern.p16_chain_of_responsibility_pattern;

/**
 * @author: 吴庆龙
 * @date: 2020/3/16 10:14 上午
 */
public abstract class Handler {
    private Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    public Handler getNext() {
        return next;
    }

    public abstract void handleRequest(String request);
}
