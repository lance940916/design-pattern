package com.snailwu.designpattern.p23_interpreter_pattern;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 吴庆龙
 * @date 2020/4/20 11:09 上午
 */
public class TerminalExpression implements Expression {
    private Set<String> set = new HashSet<>();

    public TerminalExpression(String[] data) {
        Collections.addAll(set, data);
    }

    @Override
    public boolean interpret(String info) {
        return set.contains(info);
    }
}
