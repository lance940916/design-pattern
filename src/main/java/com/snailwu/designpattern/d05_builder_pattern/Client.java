package com.snailwu.designpattern.d05_builder_pattern;

/**
 * 建造者模式
 *
 * @author 吴庆龙
 * @date 2020/2/11 11:41 上午
 */
public class Client {
    public static void main(String[] args) {
        AbstractComputerBuilder builder = new HighProfileComputerBuilder();
        Director director = new Director(builder);
        Computer highProfileComputer = director.construct();
        System.out.println(highProfileComputer); // Computer(cpu=i9, ram=32G, ssd=1T)
    }
}
