package com.snailwu.designpattern.p10_facade_pattern;

/**
 * @author: 吴庆龙
 * @date: 2020/3/2 5:00 下午
 */
public class Facade {
    private SubSystem01 system01 = new SubSystem01();
    private SubSystem02 system02 = new SubSystem02();
    private SubSystem03 system03 = new SubSystem03();

    public void f() {
        system01.f01();
        system02.f02();
        system03.f03();
    }
}
