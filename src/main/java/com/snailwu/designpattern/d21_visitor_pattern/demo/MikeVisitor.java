package com.snailwu.designpattern.d21_visitor_pattern.demo;

/**
 * @author 吴庆龙
 * @date 2020/4/13 10:39 上午
 */
public class MikeVisitor implements Visitor {
    @Override
    public void visit(ZooElement zooElement) {
        System.out.println("Mike 访问动物园, 评价:动物都很干净");
    }

    @Override
    public void visit(ParkElement parkElement) {
        System.out.println("Mike 访问公园, 评价:人比较少");
    }
}
