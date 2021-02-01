package com.snailwu.design.d14_strategy_pattern;

/**
 * @author 吴庆龙
 * @date 2020/3/9 4:20 下午
 */
public class Context {
    private Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void strategyMethod() {
        strategy.strategyMethod();
    }
}
