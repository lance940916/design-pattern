package com.snailwu.designpattern.p12_composite_pattern.pattern2;

/**
 * @author: 吴庆龙
 * @date: 2020/3/6 10:24 上午
 */
public class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    @Override
    public String name() {
        return name;
    }
}
