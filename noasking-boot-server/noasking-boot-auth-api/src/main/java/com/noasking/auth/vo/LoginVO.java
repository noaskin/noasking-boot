package com.noasking.auth.vo;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by MaJing on 2017/9/30.
 */
public class LoginVO {

    //private boolean rememberMe;

   // @NotBlank(message = "不能为空")
    private String email;

   // @NotBlank(message = "不能为空")
    private String password;
//
//    public boolean isRememberMe() {
//        return rememberMe;
//    }
//
//    public void setRememberMe(boolean rememberMe) {
//        this.rememberMe = rememberMe;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginVO{" +
                //"rememberMe=" + rememberMe +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
