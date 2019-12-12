package com.lucas.mp.demo.service;

import com.lucas.mp.demo.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 系统_用户管理 服务类
 * </p>
 *
 * @author lucas
 * @since 2019-11-29
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 用户信息
     */
    SysUser getByUsername(String username);
}
