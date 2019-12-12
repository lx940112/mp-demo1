package com.lucas.mp.demo.service.impl;

import com.lucas.mp.demo.dto.ActiveUser;
import com.lucas.mp.demo.entity.SysFunc;
import com.lucas.mp.demo.dao.SysFuncDao;
import com.lucas.mp.demo.enums.FuncTypeEnum;
import com.lucas.mp.demo.enums.StrConstant;
import com.lucas.mp.demo.enums.SuperAdminEnum;
import com.lucas.mp.demo.service.SysFuncService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统_功能管理 服务实现类
 * </p>
 *
 * @author lucas
 * @since 2019-11-29
 */
@Service
public class SysFuncServiceImpl extends ServiceImpl<SysFuncDao, SysFunc> implements SysFuncService {

    @Override
    public List<SysFunc> getMenus(ActiveUser activeUser, int funcType) {
        List<SysFunc> menuList;
        if (activeUser.getSuperAdmin() == SuperAdminEnum.YES) {
            menuList = list();
        } else {
            List<Long> funcIds = baseMapper.selectFunctionIds(activeUser.getId());
            menuList = baseMapper.selectBatchIds(funcIds);
        }
        return menuList;
    }

    @Override
    public List<SysFunc> getNavMenusByUser(ActiveUser activeUser) {
        // 先从当前用户中获取菜单列表
        List<SysFunc> menuList = activeUser.getMenus();
        // 如何当前用户中不存在菜单列表，直接查询数据库，并存放到当前用户中
        if (menuList == null) {
            menuList = getMenus(activeUser, FuncTypeEnum.MENU.value());
            SecurityUtils.getSubject().getSession().setAttribute(StrConstant.ACTIVE_USER_SESSION.getValue(), activeUser);
        }
        return menuList;
    }

}
