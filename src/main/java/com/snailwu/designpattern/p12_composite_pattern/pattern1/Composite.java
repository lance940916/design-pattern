package com.snailwu.designpattern.p12_composite_pattern.pattern1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 吴庆龙
 * @date: 2020/3/6 10:19 上午
 */
public class Composite extends Component {
    private List<Component> componentList;

    public Composite(String name) {
        super(name);
        componentList = new ArrayList<>();
    }

    @Override
    public String name() {
        StringBuilder builder = new StringBuilder(this.name);
        for (Component component : componentList) {
            builder.append("\n");
            builder.append(component.name());
        }
        return builder.toString();
    }

    @Override
    public boolean addChild(Component component) {
        return componentList.add(component);
    }

    @Override
    public boolean removeChild(Component component) {
        return componentList.remove(component);
    }

    @Override
    public Component getChild(int index) {
        return componentList.get(index);
    }
}
