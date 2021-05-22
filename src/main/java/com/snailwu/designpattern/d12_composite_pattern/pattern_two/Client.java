package com.snailwu.designpattern.d12_composite_pattern.pattern_two;

/**
 * 组合模式
 *
 * @author 吴庆龙
 * @date 2020/3/6 10:18 上午
 */
public class Client {
    public static void main(String[] args) {
        // 根节点
        Composite root = new Composite("root");

        // 树枝节点
        Composite branchA = new Composite("---branchA");
        Composite branchB = new Composite("------branchB");
        root.addChild(branchA);
        root.addChild(branchB);

        // 树叶节点
        Component leafA = new Leaf("------leafA");
        Component leafB = new Leaf("---------leafB");
        Component leafC = new Leaf("---leafC");
        branchA.addChild(leafA);
        branchA.addChild(leafB);

        // 叶子节点没有 addChild 方法
//        leafB
    }
}
