package com.snailwu.designpattern.d15_command_pattern;

/**
 * 命令模式
 *
 * @author 吴庆龙
 * @date 2020/3/11 11:44 上午
 */
public class Client {
    public static void main(String[] args) {
        Command cmd = new ConcreteCommand();
        Invoker invoker = new Invoker(cmd);
        invoker.call();
    }
}
