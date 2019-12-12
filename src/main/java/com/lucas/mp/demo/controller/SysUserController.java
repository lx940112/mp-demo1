package com.lucas.mp.demo.controller;


import com.lucas.mp.demo.entity.SysUser;
import com.lucas.mp.demo.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 系统_用户管理 前端控制器
 * </p>
 *
 * @author lucas
 * @since 2019-11-29
 */
@RestController
@RequestMapping("/sys/user")

@Api(tags = "用户标签")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("list")
    @ApiOperation(value = "查看用户列表", nickname = "查看所有用户")
    @RequiresPermissions("test")
    public List<SysUser> getUserList(HttpServletRequest request) {

        /*if (request.getSession(false) == null) {
            System.err.println("没有session或过期");
        }else {
            System.err.println("有session");
        }*/
        return sysUserService.list();
    }


    @GetMapping("one")
    @RequiresPermissions("test")
    public SysUser getUser() {
        List<SysUser> list = sysUserService.list();
        return list.get(0);
    }

}
