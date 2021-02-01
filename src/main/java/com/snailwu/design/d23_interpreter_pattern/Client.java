package com.snailwu.design.d23_interpreter_pattern;

/**
 * 解释器模式
 *
 * @author 吴庆龙
 * @date 2020/4/20 10:50 上午
 */
public class Client {
    public static void main(String[] args) {
        Context bus = new Context();
        bus.freeRide("北京的儿童");
        bus.freeRide("北京的老人");
        bus.freeRide("北京的学生");
        bus.freeRide("上海的儿童");
        bus.freeRide("上海的老人");
        bus.freeRide("广州的老人");
        bus.freeRide("广州的儿童");
    }
}
