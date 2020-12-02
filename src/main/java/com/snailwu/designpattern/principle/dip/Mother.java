package com.snailwu.designpattern.principle.dip;

/**
 * @author: 吴庆龙
 * @date: 2020/1/9 4:49 下午
 */
public class Mother {
    public void narrate(IReader reader) {
        System.out.println("妈妈开始讲故事了");
        System.out.println(reader.getContent());
    }
}
