package com.snailwu.design.d21_visitor_pattern.demo;

/**
 * @author 吴庆龙
 * @date 2020/4/13 10:45 上午
 */
public class Client {
    public static void main(String[] args) {
        ObjectStructure os = new ObjectStructure();

        // 添加两个被访问的元素
        os.addElement(new ZooElement());
        os.addElement(new ParkElement());

        // 访问者 Mike
        Visitor mv = new MikeVisitor();
        os.accept(mv);
        System.out.println("---------");

        // 访问者 Tom
        Visitor tv = new TomVisitor();
        os.accept(tv);
    }
}
