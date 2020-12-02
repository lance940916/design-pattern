package com.snailwu.designpattern.p5_builder_pattern;

/**
 * @author: 吴庆龙
 * @date: 2020/2/11 11:34 上午
 */
public class HighProfileComputerBuilder extends AbstractComputerBuilder {
    @Override
    public void buildCPU() {
        computer.setCpu("i9");
    }

    @Override
    public void buildRAM() {
        computer.setRam("32G");
    }

    @Override
    public void buildSSD() {
        computer.setSsd("1T");
    }
}
