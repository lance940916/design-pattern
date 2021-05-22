package com.snailwu.designpattern.d18_observer_pattern;

/**
 * @author 吴庆龙
 * @date 2020/3/25 10:36 上午
 */
public class ConcreteObserver2 implements Observer {
    @Override
    public void response() {
        System.out.println("具体观察者 2 作出反应");
    }
}
