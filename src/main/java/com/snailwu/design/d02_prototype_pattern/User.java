package com.snailwu.design.d02_prototype_pattern;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 必须实现接口 java.lang.Cloneable
 *
 * @author 吴庆龙
 * @date 2020/1/20 12:33 下午
 */
@Getter
@Setter
@ToString
public class User implements Cloneable {

    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    protected User clone() throws CloneNotSupportedException {
        System.out.println("原型对象复制成功");
        return (User) super.clone();
    }
}
