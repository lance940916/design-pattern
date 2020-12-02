package com.snailwu.designpattern.p1_single_pattern;

/**
 * 静态内部类实现枚举
 *
 * @author: 吴庆龙
 * @date: 2020/1/7 6:15 下午
 */
public class StaticInnerClassSingle {

    private StaticInnerClassSingle instance;

    public StaticInnerClassSingle getInstance() {
        return InnerClass.getInstance();
    }

    private static class InnerClass {

        static StaticInnerClassSingle getInstance() {
            return new StaticInnerClassSingle();
        }

    }

}
