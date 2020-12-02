package com.snailwu.designpattern.principle.lsp;

/**
 * @author: 吴庆龙
 * @date: 2020/1/8 7:30 下午
 */
public class Client {

    public static void main(String[] args) {
        Calc calc = new Calc();
        System.out.println(calc.sum(3, 5));
    }

}
