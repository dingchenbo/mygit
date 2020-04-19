package com.example.demo.common.webres.extend;

import com.example.demo.common.webres.cm.WebResCode;
import com.example.demo.common.webres.exception.WebResException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

/**
 * Author: ZhangXiao
 * Created: 2017/8/17
 */
public class Checks {

    private final static Logger LOGGER = LoggerFactory.getLogger(Checks.class);

    private static final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

    private Checks() {
    }

    public static void checkIsTrue(boolean expression) {
        if (!expression) {
            throw new WebResException(WebResCode.Invalid_Parameter.getCode());
        }
    }

    public static void checkIsFalse(boolean expression) {
        if (expression) {
            throw new WebResException(WebResCode.Invalid_Parameter.getCode());
        }
    }

    public static void checkNotNull(Object value) {
        if (value == null) {
            throw new WebResException(WebResCode.Invalid_Parameter.getCode());
        }
    }

    public static void checkIsNull(Object value) {
        if (value != null) {
            throw new WebResException(WebResCode.Invalid_Parameter.getCode());
        }
    }

    public static void checkNotEmpty(String value) {
        if (value == null || value.length() == 0) {
            throw new WebResException(WebResCode.Invalid_Parameter.getCode());
        }
    }

    public static void checkNotEmpty(List<String> value) {
        if (value != null) {
            for (String v : value) {
                checkNotEmpty(v);
            }
        } else {
            throw new WebResException(WebResCode.Invalid_Parameter.getCode());
        }
    }

    public static <E> void checkEnum(String name, Class<? extends Enum> enumType) {
        checkNotEmpty(name);
        checkNotNull(enumType);
        try {
            Enum.valueOf(enumType, name);
        } catch (IllegalArgumentException e) {
            throw new WebResException(WebResCode.Invalid_Parameter.getCode());
        }
    }

    public static void checkRange(Integer value, Integer minClosed, Integer maxClosed) {
        checkNotNull(value);
        checkNotNull(minClosed);
        checkNotNull(maxClosed);
        if (value < minClosed || value > maxClosed) {
            throw new WebResException(WebResCode.Invalid_Parameter.getCode());
        }
    }

    public static void checkRange(Long value, Long minClosed, Long maxClosed) {
        checkNotNull(value);
        checkNotNull(minClosed);
        checkNotNull(maxClosed);
        if (value < minClosed || value > maxClosed) {
            throw new WebResException(WebResCode.Invalid_Parameter.getCode());
        }
    }

    public static <T> void check(T value, Class... classes) {
        Set<ConstraintViolation<T>> constraintViolations = validatorFactory.getValidator().validate(value, classes);
        if (!constraintViolations.isEmpty()) {
            for (ConstraintViolation violation : constraintViolations) {
                LOGGER.error("Object {} property {} {} .",
                        violation.getRootBean(),
                        violation.getPropertyPath(),
                        violation.getMessage());
            }
            throw new WebResException(WebResCode.Invalid_Parameter.getCode());
        }
    }
}