package com.snailwu.design.d01_single_pattern;

/**
 * 依赖于 jvm 加载类的锁保证线程安全
 *
 * @author WuQinglong
 * @date 2021/2/1 14:55
 */
public class LazyLoadWithStaticInnerClass {

    private LazyLoadWithStaticInnerClass() {
    }

    public static LazyLoadWithStaticInnerClass getInstance() {
        return Inner.instance;
    }

    private static class Inner {
        private static final LazyLoadWithStaticInnerClass instance = new LazyLoadWithStaticInnerClass();
    }

}
