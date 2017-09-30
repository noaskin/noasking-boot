package com.noasking.auth.controller;

import com.noasking.auth.vo.AuthResultVO;
import com.noasking.auth.vo.AuthTokenVO;
import com.noasking.auth.vo.LoginVO;
import com.noasking.auth.vo.RegisterVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MaJing on 2017/9/30.
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @RequestMapping("/login")
    public AuthResultVO login(@RequestBody LoginVO loginVO) {
        System.out.println(loginVO);
        AuthResultVO authResultVO = new AuthResultVO();
        if ("ma@123.com".equals(loginVO.getEmail())) {
            authResultVO.setSuccess(true);
            authResultVO.setToken(new AuthTokenVO("dadadada"));
            authResultVO.setRedirect("/auth/login");
        } else {
            authResultVO.setSuccess(false);
            authResultVO.setErrors(new String[]{"用户名错误", "错误"});
        }
        return authResultVO;
    }

    @RequestMapping("/register")
    public AuthResultVO register(RegisterVO registerVO) {
        AuthResultVO authResultVO = new AuthResultVO();
        return authResultVO;
    }


}
