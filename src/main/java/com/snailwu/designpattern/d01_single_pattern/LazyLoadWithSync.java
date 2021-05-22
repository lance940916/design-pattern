package com.snailwu.designpattern.d01_single_pattern;

/**
 * 多线程下性能担忧
 *
 * @author WuQinglong
 * @date 2021/2/1 14:49
 */
public class LazyLoadWithSync {

    private static LazyLoadWithSync instance;

    private LazyLoadWithSync() {
    }

    public static synchronized LazyLoadWithSync getInstance() {
        if (instance == null) {
            instance = new LazyLoadWithSync();
        }
        return instance;
    }

}
