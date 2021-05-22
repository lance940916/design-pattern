package com.snailwu.designpattern.d07_adapter_pattern;

/**
 * 适配者（Adapter）类：它是被访问和适配的现存组件库中的组件接口。
 * 为了适配此类
 *
 * @author 吴庆龙
 * @date 2020/1/19 4:42 下午
 */
public class Adapter {

    public void specificHandle() {
        System.out.println("Adapter specificRequest.");
    }

}
