package com.snailwu.designpattern.principle.dip;

/**
 * @author: 吴庆龙
 * @date: 2020/1/9 4:52 下午
 */
public class Newspaper implements IReader {
    @Override
    public String getContent() {
        return "新闻";
    }
}
