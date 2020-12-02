package com.snailwu.designpattern.p7_adapter_pattern;

/**
 * 适配者（Adaptee）类：它是被访问和适配的现存组件库中的组件接口。
 *
 * @author: 吴庆龙
 * @date: 2020/1/19 4:42 下午
 */
public class Adaptee {

    public void specificHandle() {
        System.out.println("Adaptee specificRequest.");
    }

}
