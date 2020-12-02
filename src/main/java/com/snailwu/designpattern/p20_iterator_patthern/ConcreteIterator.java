package com.snailwu.designpattern.p20_iterator_patthern;

import java.util.List;

/**
 * @author 吴庆龙
 * @date 2020/4/7 10:27 上午
 */
public class ConcreteIterator extends Iterator {
    private List<Object> list;
    private int index = -1;

    public ConcreteIterator(List<Object> list) {
        this.list = list;
    }

    @Override
    public Object first() {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public Object next() {
        if (hasNext()) {
            return list.get(++index);
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        if (list == null || list.isEmpty()) {
            return false;
        }
        return index < list.size() - 1;
    }
}
