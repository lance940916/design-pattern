package com.snailwu.design.d05_builder_pattern;

import java.util.Date;

/**
 * 使用 lombok 实现的建造者模式
 *
 * @author 吴庆龙
 * @date 2020/2/11 11:57 上午
 */
public class TVClient {
    public static void main(String[] args) {
        TV tv = TV.builder()
                .name("长虹")
                .address("中国")
                .createData(new Date())
                .build();
        System.out.println(tv); // TV(name=长虹, address=中国, createData=Tue Feb 11 11:58:41 CST 2020)
    }
}
