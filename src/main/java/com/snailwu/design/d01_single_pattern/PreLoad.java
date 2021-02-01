package com.snailwu.design.d01_single_pattern;

/**
 * 不存在线程安全问题
 *
 * @author WuQinglong
 * @date 2021/2/1 14:40
 */
public class PreLoad {

    private static final PreLoad INSTANCE = new PreLoad();

    private PreLoad() {
    }

    public static PreLoad getInstance() {
        return INSTANCE;
    }
}
