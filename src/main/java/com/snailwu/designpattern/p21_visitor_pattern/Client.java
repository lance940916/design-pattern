package com.snailwu.designpattern.p21_visitor_pattern;

/**
 * @author 吴庆龙
 * @date 2020/4/10 11:49 上午
 */
public class Client {
    public static void main(String[] args) {
        ObjectStructure os = new ObjectStructure();
        os.add(new ConcreteElementA());
        os.add(new ConcreteElementB());

        Visitor visitorA = new ConcreteVisitA();
        os.accept(visitorA);
        System.out.println("------------");
        Visitor visitorB = new ConcreteVisitB();
        os.accept(visitorB);
    }
}
