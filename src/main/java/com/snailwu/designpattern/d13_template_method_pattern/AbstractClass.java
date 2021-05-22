package com.snailwu.designpattern.d13_template_method_pattern;

/**
 * @author 吴庆龙
 * @date 2020/3/9 10:17 上午
 */
public abstract class AbstractClass {
    public void getUp() {
        System.out.println("起床");
    }

    public void eatBreakfast() {
        System.out.println("吃早餐");
    }

    public abstract void work();

    public void eatDinner() {
        System.out.println("吃晚餐");
    }

    public void goToBed() {
        System.out.println("上传睡觉");
    }

    public void oneDay() {
        getUp();
        eatBreakfast();
        work();
        eatDinner();
        goToBed();
    }
}
