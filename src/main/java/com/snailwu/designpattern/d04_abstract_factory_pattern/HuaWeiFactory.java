package com.snailwu.designpattern.d04_abstract_factory_pattern;

/**
 * @author 吴庆龙
 * @date 2020/1/6 10:30 下午
 */
public class HuaWeiFactory extends AbstractFactory {
    @Override
    public AbstractTV createTV() {
        return new HuaWeiTV();
    }

    @Override
    public AbstractMobile createMobile() {
        return new HuaWeiMobile();
    }
}
