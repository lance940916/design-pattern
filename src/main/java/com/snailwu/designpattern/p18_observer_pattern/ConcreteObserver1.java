package com.snailwu.designpattern.p18_observer_pattern;

/**
 * @author 吴庆龙
 * @date 2020/3/25 10:36 上午
 */
public class ConcreteObserver1 implements Observer {
    @Override
    public void response() {
        System.out.println("具体观察者 1 作出反应");
    }
}
