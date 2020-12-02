package com.snailwu.designpattern.p6_proxy_pattern;

/**
 * @author: 吴庆龙
 * @date: 2020/2/11 4:22 下午
 */
public class Proxy {
    private Subject subject = new Subject();

    public void say() {
        beforeSay();
        subject.say();
        afterSay();
    }

    private void beforeSay() {
        System.out.println("Before say...");
    }

    private void afterSay() {
        System.out.println("After say...");
    }

}
