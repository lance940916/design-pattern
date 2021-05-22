package com.snailwu.designpattern.d07_adapter_pattern;

/**
 * 对象适配器模式
 *
 * @author 吴庆龙
 * @date 2020/1/19 4:44 下午
 */
public class ObjectAdapter implements Target {

    private final Adapter adapter;

    public ObjectAdapter(Adapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void handle() {
        adapter.specificHandle();
    }
}
