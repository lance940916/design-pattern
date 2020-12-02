package com.snailwu.designpattern.p21_visitor_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 吴庆龙
 * @date 2020/4/10 11:47 上午
 */
public class ObjectStructure {

    private List<Element> list = new ArrayList<>();

    public void accept(Visitor visitor) {
        for (Element element : list) {
            element.accept(visitor);
        }
    }

    public void add(Element element) {
        list.add(element);
    }

    public void remove(Element element) {
        list.remove(element);
    }

}
