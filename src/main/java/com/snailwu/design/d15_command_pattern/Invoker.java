package com.snailwu.design.d15_command_pattern;

/**
 * @author 吴庆龙
 * @date 2020/3/11 11:43 上午
 */
public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void call() {
        System.out.println("call 执行命令 Command");
        command.execute();
    }
}
