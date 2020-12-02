package com.snailwu.designpattern.p6_proxy_pattern;

/**
 * @author: 吴庆龙
 * @date: 2020/2/11 4:20 下午
 */
public class Subject extends AbstractSubject {
    @Override
    public void say() {
        System.out.println("访问真实主题类");
    }
}
