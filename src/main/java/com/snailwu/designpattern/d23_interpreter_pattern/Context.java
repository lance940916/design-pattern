package com.snailwu.designpattern.d23_interpreter_pattern;

/**
 * @author 吴庆龙
 * @date 2020/4/20 11:13 上午
 */
public class Context {

    private String[] cities = {"北京", "上海"};
    private String[] persons = {"儿童", "老人"};
    private Expression cityPerson;

    public Context() {
        TerminalExpression city = new TerminalExpression(cities);
        TerminalExpression person = new TerminalExpression(persons);
        cityPerson = new AndExpression(city, person);
    }

    public void freeRide(String info) {
        if (cityPerson.interpret(info)) {
            System.out.println("您是" + info + "，您本次乘车免费！");
        } else {
            System.out.println("您不是免费人员，您本次乘车免费！");
        }
    }
}
