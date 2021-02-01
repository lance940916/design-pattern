package com.snailwu.design.d20_iterator_patthern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 吴庆龙
 * @date 2020/4/7 10:26 上午
 */
public class ConcreteAggregate extends Aggregate {
    private List<Object> list = new ArrayList<>();

    @Override
    public void add(Object obj) {
        list.add(obj);
    }

    @Override
    public void remove(Object obj) {
        list.remove(obj);
    }

    @Override
    public Iterator getIterator() {
        return new ConcreteIterator(this.list);
    }
}
