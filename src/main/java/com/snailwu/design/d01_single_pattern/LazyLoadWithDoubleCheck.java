package com.snailwu.design.d01_single_pattern;

/**
 * 这种方式可能会因为重排序导致实例未初始化就被使用的问题
 *
 * @author WuQinglong
 * @date 2021/2/1 14:51
 */
public class LazyLoadWithDoubleCheck {

    private static LazyLoadWithDoubleCheck instance;
    private static final Object lock = new Object();

    private LazyLoadWithDoubleCheck() {
    }

    public static LazyLoadWithDoubleCheck getInstance() {
        if (instance == null) {
            synchronized (lock) {
                instance = new LazyLoadWithDoubleCheck();
            }
        }
        return instance;
    }

}
