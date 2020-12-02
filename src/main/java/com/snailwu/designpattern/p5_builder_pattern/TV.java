package com.snailwu.designpattern.p5_builder_pattern;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author: 吴庆龙
 * @date: 2020/2/11 11:56 上午
 */
@Getter
@Setter
@ToString
@Builder
public class TV {

    private String name;
    private String address;
    private Date createData;

}
