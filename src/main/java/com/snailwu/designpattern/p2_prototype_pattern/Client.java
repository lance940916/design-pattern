package com.snailwu.designpattern.p2_prototype_pattern;

/**
 * 原型模式
 *
 * @author: 吴庆龙
 * @date: 2020/1/20 12:34 下午
 */
public class Client {

    public static void main(String[] args) throws CloneNotSupportedException {
        User user = new User("Mike");
        System.out.println(user);

        User cloneUser = user.clone();
        System.out.println(cloneUser);
    }

}
