package com.snailwu.design.d14_strategy_pattern;

/**
 * 策略模式，使用某个策略完成某个事情
 *
 * @author 吴庆龙
 * @date 2020/3/9 4:20 下午
 */
public class Client {
    public static void main(String[] args) {
        Strategy strategyA = new ConcreteStrategyA();
        Strategy strategyB = new ConcreteStrategyB();

        Context context = new Context();
        context.setStrategy(strategyA);
        context.strategyMethod();

        context.setStrategy(strategyB);
        context.strategyMethod();
    }
}
