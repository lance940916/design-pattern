package com.snailwu.designpattern.principle.isp;

/**
 * @author: 吴庆龙
 * @date: 2020/1/9 5:05 下午
 */
interface I1 {
    void m1();
}

interface I2 {
    void m2();
}

interface I3 {
    void m3();
}

class A {
    public void d1(I1 i) {
        i.m1();
    }
    public void d2(I2 i) {
        i.m2();
    }
}

// 对于 B 来说，m3 方法是不是必须的
// 但是在实现过程中即使这个方法方法体是空，也要将这个没用的方法进行实现
class B implements I1, I2 {
    @Override
    public void m1() {
        System.out.println("B m1");
    }
    @Override
    public void m2() {
        System.out.println("B m2");
    }
}

class C {
    public void d2(I2 i) {
        i.m2();
    }
    public void d3(I3 i) {
        i.m3();
    }
}

// 对于 D 来说，m1 方法是不是必须的
// 但是在实现过程中即使这个方法方法体是空，也要将这个没用的方法进行实现
class D implements I2, I3 {
    @Override
    public void m2() {
        System.out.println("D m2");
    }
    @Override
    public void m3() {
        System.out.println("D m3");
    }
}

public class Client {
    public static void main(String[] args) {
        B b = new B();
        A a = new A();
        a.d1(b);
        a.d2(b);

        D d = new D();
        C c = new C();
        c.d2(d);
        c.d3(d);
    }
}