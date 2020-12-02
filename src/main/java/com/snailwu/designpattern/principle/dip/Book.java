package com.snailwu.designpattern.principle.dip;

/**
 * @author: 吴庆龙
 * @date: 2020/1/9 4:48 下午
 */
public class Book implements IReader {
    @Override
    public String getContent() {
        return "阿拉伯的故事";
    }
}
