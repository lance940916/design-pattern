package com.snailwu.designpattern.p7_adapter_pattern;

/**
 * 对象适配器模式
 *
 * @author: 吴庆龙
 * @date: 2020/1/19 4:44 下午
 */
public class ObjectAdapter implements Target{

    private Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void handle() {
        adaptee.specificHandle();
    }
}
