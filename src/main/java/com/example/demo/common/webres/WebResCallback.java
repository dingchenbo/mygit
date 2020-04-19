package com.example.demo.common.webres;


import com.example.demo.common.webres.common.CodeMessage;
import com.example.demo.common.webres.common.WebResCriteria;
import com.example.demo.common.webres.common.WebResInfo;
import com.example.demo.common.webres.exception.WebResException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Web请求响应处理逻辑模版类
 * Author : secondriver
 * Date   : 2016/7/17
 */
public abstract class WebResCallback {

    private final Logger logger = LoggerFactory.getLogger(WebResCallback.class);

    private final WebResCriteria criteria = new WebResCriteria();

    /**
     * 处理逻辑
     *
     * @param criteria 处理结果
     * @param params   请求参数
     */
    public abstract void execute(final WebResCriteria criteria, Object... params);

    /**
     * 发送请求参数
     *
     * @param params
     * @return
     */
    public final WebResInfo sendRequest(Object... params) {
        WebResInfo webResInfo = new WebResInfo();
        try {
            execute(criteria, params);
            CodeMessage ok = CodeMessageManageFactory.getInstance().codeMessage("200");
            webResInfo.setCode(ok.getCode());
            webResInfo.setMessage(ok.getMessage());
            webResInfo.setData(criteria.getResult());
        } catch (WebResException e) {
            webResInfo.setCode(e.getCode());
            webResInfo.setMessage(e.getMessage());
            if (null != e.getObj()){
                webResInfo.setData(e.getObj());
            }
            logger.error("WebResInfo ", e);
        } catch (Exception | Error e) {
            CodeMessage server = CodeMessageManageFactory.getInstance().codeMessage("500");
            webResInfo.setCode(server.getCode());
            webResInfo.setMessage(server.getMessage());
            logger.error("WebResInfo ", e);
        }
        return webResInfo;
    }

    public final String sendBody(Object... params) {
        return (String) this.sendRequest(params).getData();
    }
}