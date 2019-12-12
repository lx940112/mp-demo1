package com.lucas.mp.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Maps;
import com.lucas.mp.demo.entity.SysUser;
import com.lucas.mp.demo.dao.SysUserDao;
import com.lucas.mp.demo.enums.UserStatusEnum;
import com.lucas.mp.demo.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/**
 * <p>
 * 系统_用户管理 服务实现类
 * </p>
 *
 * @author lucas
 * @since 2019-11-29
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements SysUserService {

    @Override
    public SysUser getByUsername(String username) {

        SysUser user = new SysUser();
        user.setUsername("admin");
        String random = new SecureRandomNumberGenerator().nextBytes().toString();
        user.setSalt(random);
        String result = new SimpleHash(Sha256Hash.ALGORITHM_NAME,"123", random, 1024).toString();
        user.setPassword(result);

        user.setStatus(UserStatusEnum.NORMAL);


        /*LambdaQueryWrapper wrapper = new LambdaQueryWrapper();
        Map<String, Object> params = Maps.newConcurrentMap();
        params.put("username", username);
        params.put("status", UserStatusEnum.NORMAL.value());
        wrapper.allEq(params);
        return baseMapper.selectOne(wrapper);*/
        return user;
    }
}
