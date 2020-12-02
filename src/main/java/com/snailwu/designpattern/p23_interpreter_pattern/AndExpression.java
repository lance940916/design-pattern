package com.snailwu.designpattern.p23_interpreter_pattern;

/**
 * @author 吴庆龙
 * @date 2020/4/20 11:11 上午
 */
public class AndExpression implements Expression {
    private Expression city;
    private Expression person;

    public AndExpression(Expression city, Expression person) {
        this.city = city;
        this.person = person;
    }

    @Override
    public boolean interpret(String info) {
        String[] s = info.split("的");
        return city.interpret(s[0]) && person.interpret(s[1]);
    }
}
