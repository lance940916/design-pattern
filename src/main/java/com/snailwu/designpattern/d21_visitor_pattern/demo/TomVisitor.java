package com.snailwu.designpattern.d21_visitor_pattern.demo;

/**
 * @author 吴庆龙
 * @date 2020/4/13 10:41 上午
 */
public class TomVisitor implements Visitor {
    @Override
    public void visit(ZooElement zooElement) {
        System.out.println("Tom 访问动物园, 评价:很多人乱喂动物");
    }

    @Override
    public void visit(ParkElement parkElement) {
        System.out.println("Tom 访问公园, 评价:空气很好");
    }
}
