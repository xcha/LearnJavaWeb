package com.lianci.controller;

import com.lianci.pojo.Emp;
import com.lianci.pojo.LoginInfo;
import com.lianci.pojo.Result;
import com.lianci.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping ("/login")
public class LoginController {


    private final EmpService empService;

    public LoginController(EmpService empService) {
        this.empService = empService;
    }

    @PostMapping
    public Result login(@RequestBody Emp emp) {
        log.info("登录: {}", emp);
        LoginInfo info = empService.login(emp);
        if (info != null) {
            return Result.success(info);
        }
        return Result.error("用户名或密码错误");
    }
}
