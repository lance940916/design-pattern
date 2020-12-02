package com.snailwu.designpattern.p18_observer_pattern;

/**
 * @author 吴庆龙
 * @date 2020/3/25 10:37 上午
 */
public class ObserverPattern {
    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        Observer observer1 = new ConcreteObserver1();
        Observer observer2 = new ConcreteObserver2();

        subject.add(observer1);
        subject.add(observer2);
        subject.notifyObserver();

        subject.remove(observer1);
        subject.notifyObserver();
    }
}
