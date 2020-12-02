package com.snailwu.designpattern.p7_adapter_pattern;

/**
 * @author: 吴庆龙
 * @date: 2020/1/19 4:45 下午
 */
public class Client {

    public static void main(String[] args) {

        Target classAdapter = new ClassAdapter();
        classAdapter.handle();

        Adaptee adaptee = new Adaptee();
        Target objectAdapter = new ObjectAdapter(adaptee);
        objectAdapter.handle();
    }

}
