package com.snailwu.designpattern.d03_factory_method_pattern;

/**
 * @author 吴庆龙
 * @date 2020/1/6 10:00 下午
 */
public abstract class AbstractAnimalFactory {

    /**
     * 创建具体的动物
     */
    public abstract AbstractAnimal create();

}
