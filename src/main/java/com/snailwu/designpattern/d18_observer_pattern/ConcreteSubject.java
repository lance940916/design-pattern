package com.snailwu.designpattern.d18_observer_pattern;

/**
 * @author 吴庆龙
 * @date 2020/3/25 10:35 上午
 */
public class ConcreteSubject extends Subject {
    @Override
    public void notifyObserver() {
        System.out.println("具体目标发生变化...");
        for (Observer observer : observerList) {
            observer.response();
        }
    }
}
