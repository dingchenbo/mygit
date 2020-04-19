package com.example.demo.common.webres.cm;


import com.example.demo.common.webres.common.CodeMessage;
import com.example.demo.common.webres.source.CodeMessageSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: ZhangXiao
 * Created: 2017/6/26
 */
class ConstantCodeMessage implements CodeMessageSource {

    private final Logger logger = LoggerFactory.getLogger(ConstantCodeMessage.class);

    @Override
    public List<CodeMessage> loadSource() {
        List<CodeMessage> codeMessages = new ArrayList<>();
        Field[] fields = WebResCode.class.getFields();
        for (Field field : fields) {
            if (field.getType().equals(CodeMessage.class)) {
                try {
                    Object o = field.get(WebResCode.class);
                    CodeMessage codeMessage = (CodeMessage) o;
                    codeMessage.setId(field.getName());
                    codeMessages.add(codeMessage);
                } catch (IllegalAccessException e) {
                    logger.warn("Extract CodeMessage instance exception.", e);
                }
            }
        }
        return codeMessages;
    }

    @Override
    public int order() {
        return 0;
    }
}