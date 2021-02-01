package com.snailwu.design.d11_flyweight_pattern;

import lombok.Getter;
import lombok.Setter;

/**
 * 非享元角色
 *
 * @author 吴庆龙
 * @date 2020/3/3 2:59 下午
 */
@Getter
@Setter
public class UnsharedConcreteFlyweight {
    private String info;

    public UnsharedConcreteFlyweight(String info) {
        this.info = info;
    }
}
