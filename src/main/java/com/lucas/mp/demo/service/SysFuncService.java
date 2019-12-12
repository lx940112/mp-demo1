package com.lucas.mp.demo.service;

import com.lucas.mp.demo.dto.ActiveUser;
import com.lucas.mp.demo.entity.SysFunc;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 系统_功能管理 服务类
 * </p>
 *
 * @author lucas
 * @since 2019-11-29
 */
public interface SysFuncService extends IService<SysFunc> {

    /**
     * 根据用户ID查询其对应的菜单
     * @param activeUser 用户ID
     * @param funcType 菜单类别
     * @return 菜单列表
     */
    List<SysFunc> getMenus(ActiveUser activeUser, int funcType);

    /**
     * 根据用户ID查询其对应的菜单
     * @param activeUser 用户ID
     * @return 菜单列表
     */
    List<SysFunc> getNavMenusByUser(ActiveUser activeUser);
}
