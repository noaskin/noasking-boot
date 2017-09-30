package com.noasking.auth.config;

import lombok.Data;

/**
 * 自定义参数异常返回的数据类
 * Created by MaJing on 2017/9/30.
 */
@Data
public class ArgumentInvalidResult {

    private String field;
    private Object rejectedValue;
    private String defaultMessage;

}
