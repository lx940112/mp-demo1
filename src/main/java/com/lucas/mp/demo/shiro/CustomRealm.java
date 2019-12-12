package com.lucas.mp.demo.shiro;

import com.lucas.mp.demo.dto.ActiveUser;
import com.lucas.mp.demo.entity.SysUser;
import com.lucas.mp.demo.enums.UserStatusEnum;
import com.lucas.mp.demo.service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liuxu
 */
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;

    //告诉shiro如何根据获取到的用户信息中的密码和盐值来校验密码
    {
        //设置用于匹配密码的CredentialsMatcher
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName(Sha256Hash.ALGORITHM_NAME);
        matcher.setStoredCredentialsHexEncoded(true);
        matcher.setHashIterations(1024);
        this.setCredentialsMatcher(matcher);
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        Set<String> list = new HashSet<>();
        list.add("test");
        info.setStringPermissions(list);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // token是用户输入的用户名和密码
        // 1.从token中取出用户名
        String username = (String) token.getPrincipal();
        SysUser user = sysUserService.getByUsername(username);
        if (user == null) {
            throw new UnknownAccountException("账号或者密码有误");
        }
        if (!UserStatusEnum.NORMAL.equals(user.getStatus())) {
            throw new UnknownAccountException("账号异常，登录失败");
        }

        String password = user.getPassword();
        ActiveUser activeUser = new ActiveUser();
        activeUser = activeUser.convertFrom(user);

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(activeUser, password, ByteSource.Util.bytes(user.getSalt()),this.getName());

        return authenticationInfo;
    }
}
