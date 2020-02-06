package com.wyl.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description LoginController
 * @Author YiLong Wu
 * @Date 2020/2/4 19:08
 * @Version 1.0.0
 */
@RestController
public class LoginController {

    @RequestMapping(value = "/loginSuccess",produces = {"text/plain;charset=utf-8"})
    public String loginSuccess() {

        return "登录成功";
    }

    @GetMapping(value = "/r/r1",produces = {"text/plain;charset=utf-8"})
    public String getResource() {
        return "访问资源";
    }
}
