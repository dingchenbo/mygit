package com.example.demo.common.webres.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Web接口响应信息
 * Author : secondriver
 * Date   : 2016/7/17
 */
@Setter
@Getter
@ToString
public class WebResInfo {
    
    /**
     * 响应码
     */
    private String code;
    
    /**
     * 响应信息
     */
    private String message;
    
    /**
     * 响应结果即数据
     */
    private Object data;
    
}
