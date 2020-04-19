package com.example.demo.common.webres.exception;

import com.example.demo.common.webres.CodeMessageManageFactory;

/**
 * Web接口统一异常类
 * Author : secondriver
 * Date   : 2016/7/17
 */
public class WebResException extends RuntimeException {

    private final String code;

    private final String message;

    private final Object obj;

    /**
     * Code Message中message无占位符的使用此方法
     *
     * @param code
     */
    public WebResException(String code) {
        this.code = code;
        this.message = CodeMessageManageFactory.getInstance().message(code);
        this.obj = null;
    }

    /**
     * Code Message中message有占位符的使用此方法
     *
     * @param code
     * @param params
     */
    public WebResException(String code, Object... params) {
        this.code = code;
        this.message = String.format(CodeMessageManageFactory.getInstance().message(code), params);
        this.obj = null;
    }

    public WebResException(String message, Throwable cause, String code) {
        super(message, cause);
        this.code = code;
        this.message = message;
        this.obj = null;
    }

    public WebResException(String code,Object obj) {
        this.code = code;
        this.message = CodeMessageManageFactory.getInstance().message(code);
        this.obj = obj;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Object getObj() {
        return obj;
    }

}