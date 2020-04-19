package com.example.demo.common.webres.common;

import com.example.demo.common.webres.exception.WebResCriteriaException;

import java.util.HashMap;
import java.util.Map;

/**
 * Web响应标准类，处理业务层结果
 * Author : secondriver
 * Date   : 2016/7/17
 */
public class WebResCriteria {

    private Object single;

    private Map<String, Object> object;

    /**
     * 添加单值结果
     *
     * @param value
     */
    public void addSingleResult(Object value) {
        if (null != object) {
            throw new WebResCriteriaException("WebResCriteria map result object already has value.");
        }
        this.single = value;
    }

    /**
     * 添加多值结果
     *
     * @param key
     * @param value
     * @return
     */
    public WebResCriteria addMultiResult(String key, Object value) {
        Asserts.notNull(key, "MultiResult key can't be null.");
        if (null != single) {
            throw new WebResCriteriaException("WebResCriteria single value result object already has value.");
        }
        if (null == object) {
            object = new HashMap<>();
        }
        object.put(key, value);
        return this;
    }

    /**
     * 获取结果
     *
     * @return
     */
    public Object getResult() {
        if (null != single) {
            return single;
        }
        if (null != object) {
            return object;
        }
        return null;
    }
}