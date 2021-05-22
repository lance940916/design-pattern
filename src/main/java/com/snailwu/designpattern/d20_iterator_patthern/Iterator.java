package com.snailwu.designpattern.d20_iterator_patthern;

/**
 * @author 吴庆龙
 * @date 2020/4/7 10:25 上午
 */
public abstract class Iterator {
    public abstract Object first();

    public abstract Object next();

    public abstract boolean hasNext();
}
