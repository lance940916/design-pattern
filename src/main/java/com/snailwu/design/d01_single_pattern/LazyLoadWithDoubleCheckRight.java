package com.snailwu.design.d01_single_pattern;

/**
 * 使用 volatile 解决因为重排序导致实例未初始化就被使用的问题
 *
 * @author WuQinglong
 * @date 2021/2/1 14:51
 */
public class LazyLoadWithDoubleCheckRight {

    private static volatile LazyLoadWithDoubleCheckRight instance;
    private static final Object lock = new Object();

    private LazyLoadWithDoubleCheckRight() {
    }

    public static LazyLoadWithDoubleCheckRight getInstance() {
        if (instance == null) {
            synchronized (lock) {
                instance = new LazyLoadWithDoubleCheckRight();
            }
        }
        return instance;
    }

}
