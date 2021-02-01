package com.snailwu.design.d12_composite_pattern.pattern_one;

/**
 * 组合模式
 *
 * @author 吴庆龙
 * @date 2020/3/6 10:18 上午
 */
public class Client {
    public static void main(String[] args) {
        // 根节点
        Component root = new Composite("root");

        // 树枝节点
        Component branchA = new Composite("---branchA");
        Component branchB = new Composite("------branchB");
        root.addChild(branchA);
        root.addChild(branchB);

        // 树叶节点
        Component leafA = new Leaf("------leafA");
        Component leafB = new Leaf("---------leafB");
        Component leafC = new Leaf("---leafC");
        branchA.addChild(leafA);
        branchA.addChild(leafB);

        // 叶子节点不支持添加子节点操作，叶子节点只能被添加
        leafB.addChild(leafC);
    }
}
