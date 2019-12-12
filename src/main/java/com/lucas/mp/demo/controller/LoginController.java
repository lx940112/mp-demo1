package com.lucas.mp.demo.controller;

import com.lucas.mp.demo.dto.ActiveUser;
import com.lucas.mp.demo.dto.UserLoginDTO;
import com.lucas.mp.demo.entity.SysFunc;
import com.lucas.mp.demo.service.SysFuncService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.HttpMethod;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liuxu
 */
@RestController
@RequestMapping("/auth")
@Api(tags = "登录")
public class LoginController {

    @Autowired
    private SysFuncService sysFuncService;

    @PostMapping("/login")
    @ApiOperation(httpMethod = "POST", value = "用户登录接口")
    public String login(@Validated @RequestBody UserLoginDTO user) {

        /*获取subject，封装用户名密码然后进行登录*/
        Subject subject = SecurityUtils.getSubject();
        // 设置session过期时间
        // subject.getSession().setTimeout(5000L);
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        subject.login(token);

        ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
        List<SysFunc> menus = sysFuncService.getMenus(activeUser);

        // System.err.println("this is user login method，hello ：" + userLoginDTO.getUsername() + ".!");
        // return "this is user login method，hello ：" + userLoginDTO.getUsername() + "!";
        return "OK";
    }

    @GetMapping("toLogin")
    @ApiOperation(httpMethod = "GET",value = "去登录")
    public String toLogin(){
        return "登录过期，请前去登录页登录";
    }

}
