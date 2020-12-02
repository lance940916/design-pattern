package com.snailwu.designpattern.principle.single;

/**
 * @author: 吴庆龙
 * @date: 2020/1/8 10:51 上午
 */
public class Client {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.breathe("猫");
        animal.breathe("牛");
        animal.breathe("猪");
    }
}
