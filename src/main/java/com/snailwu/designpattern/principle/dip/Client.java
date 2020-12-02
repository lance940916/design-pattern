package com.snailwu.designpattern.principle.dip;

/**
 * @author: 吴庆龙
 * @date: 2020/1/9 4:50 下午
 */
public class Client {
    public static void main(String[] args) {
        Mother mother = new Mother();
        mother.narrate(new Book());
        mother.narrate(new Newspaper());
    }
}
