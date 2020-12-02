package com.snailwu.designpattern.p3_factory_method_pattern;

/**
 * @author: 吴庆龙
 * @date: 2020/1/6 10:02 下午
 */
public class BirdAnimalFactory extends AbstractAnimalFactory {
    @Override
    public AbstractAnimal create() {
        return new Bird();
    }
}
