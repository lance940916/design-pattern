package com.snailwu.designpattern.d15_command_pattern;

/**
 * @author 吴庆龙
 * @date 2020/3/11 9:59 上午
 */
public class ConcreteCommand extends Command {
    private Receiver receiver;

    public ConcreteCommand() {
        this.receiver = new Receiver();
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
