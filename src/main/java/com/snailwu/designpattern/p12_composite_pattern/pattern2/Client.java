package com.snailwu.designpattern.p12_composite_pattern.pattern2;

/**
 * @author: 吴庆龙
 * @date: 2020/3/6 10:18 上午
 */
public class Client {
    public static void main(String[] args) {
        // 根节点
        Composite root = new Composite("root");
        // 树枝节点
        Composite branchA = new Composite("---branchA");
        Composite branchB = new Composite("------branchB");
        // 树叶节点
        Component leafA = new Leaf("------leafA");
        Component leafB = new Leaf("---------leafB");
        Component leafC = new Leaf("---leafC");

        root.addChild(branchA);
        root.addChild(leafC);

        branchA.addChild(leafA);
        branchA.addChild(branchB);

        branchB.addChild(leafB);

        // 叶子节点不支持操作
//        leafC.addChild(null);

        String result = root.name();
        System.out.println(result);
    }
}
