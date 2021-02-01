package com.snailwu.design.d21_visitor_pattern.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 吴庆龙
 * @date 2020/4/13 10:43 上午
 */
public class ObjectStructure {
    private List<Element> list = new ArrayList<>();

    public void accept(Visitor visitor) {
        for (Element ele : list) {
            ele.accept(visitor);
        }
    }

    public void addElement(Element element) {
        list.add(element);
    }

    public void delElement(Element element) {
        list.remove(element);
    }
}
