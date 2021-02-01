package com.snailwu.design.d01_single_pattern;

/**
 * 多线程下会创建多个实例
 *
 * @author WuQinglong
 * @date 2021/2/1 14:48
 */
public class LazyLoadWithNull {

    private static LazyLoadWithNull instance;

    private LazyLoadWithNull() {
    }

    public static LazyLoadWithNull getInstance() {
        if (instance == null) {
            instance = new LazyLoadWithNull();
        }
        return instance;
    }

}
