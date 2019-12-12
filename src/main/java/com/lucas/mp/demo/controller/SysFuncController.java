package com.lucas.mp.demo.controller;


import com.lucas.mp.demo.dto.ActiveUser;
import com.lucas.mp.demo.entity.SysFunc;
import com.lucas.mp.demo.enums.StrConstant;
import com.lucas.mp.demo.service.SysFuncService;
import com.lucas.mp.demo.vo.response.RespResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 系统_功能管理 前端控制器
 * </p>
 *
 * @author lucas
 * @since 2019-11-29
 */
@RestController
@RequestMapping("/sys/func")
public class SysFuncController {

    @Autowired
    private SysFuncService sysFuncService;

    @GetMapping("nav")
    public RespResult<List<SysFunc>> getNavMenusByUser(HttpServletRequest request) {
        ActiveUser activeUser = (ActiveUser) request.getSession().getAttribute(StrConstant.ACTIVE_USER_SESSION.getValue());
        List<SysFunc> navMenuList = sysFuncService.getNavMenusByUser(activeUser);
        return new RespResult<List<SysFunc>>().ok(navMenuList);
    }




}
