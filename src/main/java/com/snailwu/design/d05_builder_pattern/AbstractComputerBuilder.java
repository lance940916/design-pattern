package com.snailwu.design.d05_builder_pattern;

/**
 * @author 吴庆龙
 * @date 2020/2/11 11:30 上午
 */
public abstract class AbstractComputerBuilder {

    protected Computer computer = new Computer();

    public abstract void buildCPU();

    public abstract void buildRAM();

    public abstract void buildSSD();

    public Computer getResult() {
        return computer;
    }

}
