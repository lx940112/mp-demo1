package com.lucas.mp.demo.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.lucas.mp.demo.enums.DelFlagEnum;
import com.lucas.mp.demo.enums.SuperAdminEnum;
import com.lucas.mp.demo.enums.UserGenderEnum;
import com.lucas.mp.demo.enums.UserStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统_用户管理
 * </p>
 *
 * @author lucas
 * @since 2019-11-29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_user")
public class SysUser implements Serializable {

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
    @JSONField(name = "gender")
    private UserGenderEnum gender;

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
    private SuperAdminEnum superAdmin;

    /**
     * 状态
     */
    private UserStatusEnum status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 删除标识:1-未删除; 0-删除
     */
    private DelFlagEnum delFlag;

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

}
