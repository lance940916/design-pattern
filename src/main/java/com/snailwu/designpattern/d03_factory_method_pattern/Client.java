package com.snailwu.designpattern.d03_factory_method_pattern;

/**
 * 工厂方法模式
 *
 * @author 吴庆龙
 * @date 2020/2/10 4:24 下午
 */
public class Client {
    public static void main(String[] args) {
        AbstractAnimalFactory factory = new CatAnimalFactory();
        AbstractAnimal animal = factory.create();
        System.out.println(animal.getName());
    }
}
