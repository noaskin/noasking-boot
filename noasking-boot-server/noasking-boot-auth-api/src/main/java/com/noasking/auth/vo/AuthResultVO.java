package com.noasking.auth.vo;

import lombok.Data;

/**
 * Created by MaJing on 2017/9/30.
 */
@Data
public class AuthResultVO {

    public String[] errors;

    public String[] messages;

    private boolean success;

    private String redirect;

    private String response;

    private AuthTokenVO token;
}
