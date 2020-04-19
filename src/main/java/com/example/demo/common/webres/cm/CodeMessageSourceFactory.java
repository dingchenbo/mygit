package com.example.demo.common.webres.cm;


import com.example.demo.common.webres.source.CodeMessageSource;

/**
 * Author: ZhangXiao
 * Created: 2017/6/26
 */
public final class CodeMessageSourceFactory {
    
    public static CodeMessageSource create() {
        return new ConstantCodeMessage();
    }
}
