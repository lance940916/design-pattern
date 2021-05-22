package com.snailwu.designpattern.d18_observer_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 吴庆龙
 * @date 2020/3/25 10:32 上午
 */
public abstract class Subject {
    protected List<Observer> observerList = new ArrayList<>();

    /**
     * 新增观察者
     */
    public void add(Observer observer) {
        observerList.add(observer);
    }

    public void remove(Observer observer) {
        observerList.remove(observer);
    }

    /**
     * 通知观察者
     */
    public abstract void notifyObserver();
}
