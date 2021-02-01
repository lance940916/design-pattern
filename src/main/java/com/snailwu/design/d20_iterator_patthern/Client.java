package com.snailwu.design.d20_iterator_patthern;

/**
 * 迭代器模式
 *
 * @author 吴庆龙
 * @date 2020/4/7 10:30 上午
 */
public class Client {
    public static void main(String[] args) {
        Aggregate aggregate = new ConcreteAggregate();
        aggregate.add("1");
        aggregate.add("3");
        aggregate.add("5");
        aggregate.add("7");

        Iterator iter = aggregate.getIterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
