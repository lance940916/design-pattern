package com.snailwu.designpattern.p20_iterator_patthern;

/**
 * @author 吴庆龙
 * @date 2020/4/7 10:23 上午
 */
public abstract class Aggregate {

    public abstract void add(Object obj);

    public abstract void remove(Object obj);

    public abstract Iterator getIterator();
}
