package com.snailwu.designpattern.p7_adapter_pattern;

/**
 * 类适配器模式
 *
 * @author: 吴庆龙
 * @date: 2020/1/19 4:44 下午
 */
public class ClassAdapter extends Adaptee implements Target {

    @Override
    public void handle() {
        specificHandle();
    }
}
