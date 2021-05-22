package com.snailwu.designpattern.d05_builder_pattern;

/**
 * @author 吴庆龙
 * @date 2020/2/11 11:40 上午
 */
public class Director {

    private AbstractComputerBuilder builder;

    public Director(AbstractComputerBuilder builder) {
        this.builder = builder;
    }

    public Computer construct() {
        builder.buildCPU();
        builder.buildRAM();
        builder.buildSSD();
        return builder.getResult();
    }

}
