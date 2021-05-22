package com.snailwu.designpattern.d19_mediator_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 吴庆龙
 * @date 2020/4/1 10:19 上午
 */
public class ConcreteMediator extends Mediator {

    private List<Colleague> list = new ArrayList<>();

    @Override
    public void register(Colleague colleague) {
        if (!list.contains(colleague)) {
            list.add(colleague);
            colleague.setMediator(this);
        }
    }

    @Override
    public void relay(Colleague colleague) {
        for (Colleague c : list) {
            if (!c.equals(colleague)) {
                c.receive();
            }
        }
    }
}
