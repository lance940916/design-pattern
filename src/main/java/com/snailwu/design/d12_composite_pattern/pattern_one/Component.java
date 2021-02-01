package com.snailwu.design.d12_composite_pattern.pattern_one;

/**
 * @author 吴庆龙
 * @date 2020/3/6 10:18 上午
 */
public abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract String name();

    public boolean addChild(Component component) {
        throw new UnsupportedOperationException("addChild not supported!");
    }

    public boolean removeChild(Component component) {
        throw new UnsupportedOperationException("removeChild not supported!");
    }

    public Component getChild(int index) {
        throw new UnsupportedOperationException("getChild not supported!");
    }
}
