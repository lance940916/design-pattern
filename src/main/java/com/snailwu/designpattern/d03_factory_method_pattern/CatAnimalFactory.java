package com.snailwu.designpattern.d03_factory_method_pattern;

/**
 * @author 吴庆龙
 * @date 2020/1/6 10:02 下午
 */
public class CatAnimalFactory extends AbstractAnimalFactory {
    @Override
    public AbstractAnimal create() {
        return new Cat();
    }
}
