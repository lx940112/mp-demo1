package com.lucas.mp.demo.dto;

import com.lucas.mp.demo.convert.Converter;
import com.lucas.mp.demo.entity.SysUser;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 系统_用户管理 传输对象
 * </p>
 *
 * @author lucas
 * @since 2019-11-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysUserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
    private String realName;

    /**
     * 性别: 0-女; 1-男; 2-保密
     */
    private Integer gender;

    /**
     * 头像地址
     */
    private String iconUrl;

    /**
     * 描述
     */
    private String userDesc;

    /**
     * 电话
     */
    private String telephone;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 盐值
     */
    private String salt;

    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 超级管理员: 1-是; 0-不是
     */
    private Integer superAdmin;

    /**
     * 状态
     */
    private String status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 删除标识:1-未删除; 0-删除
     */
    private Integer delFlag;

    /**
     * 末次密码更新时间
     */
    private LocalDateTime pwResetTime;

    /**
     * 创建人
     */
    private Long createUser;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    private Long updateUser;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


    /**
     * 将DTO对象转换成Entity对象
     *
     * @return SysUser
     */
    public SysUser convertToUser() {
        UserDTOConvert userDTOConvert = new UserDTOConvert();
        return userDTOConvert.doForward(this);
    }

    /**
     * 将Entity对象转换成DTO对象
     *
     * @param user SysUser
     * @return SysUserDTO
     */
    public SysUserDTO convertFrom(SysUser user) {
        UserDTOConvert userDTOConvert = new UserDTOConvert();
        return userDTOConvert.doBackward(user);
    }

    /**
     * DTO与Entity相互转换的静态内部类
     */
    private static class UserDTOConvert implements Converter<SysUser, SysUserDTO> {

        @Override
        public SysUser doForward(SysUserDTO dto) {
            SysUser user = new SysUser();
            BeanUtils.copyProperties(dto, user);
            return user;
        }

        @Override
        public SysUserDTO doBackward(SysUser user) {
            SysUserDTO dto = new SysUserDTO();
            BeanUtils.copyProperties(user, dto);
            return dto;
        }

    }


}
