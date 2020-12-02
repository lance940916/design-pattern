package com.snailwu.designpattern.p6_proxy_pattern;

/**
 * @author: 吴庆龙
 * @date: 2020/2/11 4:23 下午
 */
public class Client {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.say();
    }
}
