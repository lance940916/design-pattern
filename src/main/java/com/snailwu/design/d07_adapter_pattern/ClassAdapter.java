package com.snailwu.design.d07_adapter_pattern;

/**
 * 类适配器模式
 *
 * @author 吴庆龙
 * @date 2020/1/19 4:44 下午
 */
public class ClassAdapter extends Adapter implements Target {

    @Override
    public void handle() {
        specificHandle();
    }
}
