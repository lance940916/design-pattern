package com.snailwu.designpattern.d07_adapter_pattern;

/**
 * 适配器模式
 *
 * @author 吴庆龙
 * @date 2020/1/19 4:45 下午
 */
public class Client {

    public static void main(String[] args) {

        Target classAdapter = new ClassAdapter();
        classAdapter.handle();

        Adapter adapter = new Adapter();
        Target objectAdapter = new ObjectAdapter(adapter);
        objectAdapter.handle();
    }

}
