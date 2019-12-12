package com.lucas.mp.demo.dto;

import com.lucas.mp.demo.convert.Converter;
import com.lucas.mp.demo.entity.SysFunc;
import com.lucas.mp.demo.entity.SysUser;
import com.lucas.mp.demo.enums.SuperAdminEnum;
import com.lucas.mp.demo.enums.UserStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ActiveUser implements Serializable {

    private Long id;
    private String username;
    private String realName;
    private String avatar;
    private UserStatusEnum status;
    private String deptId;
    private String userIp;

    private SuperAdminEnum superAdmin;

    private List<Long> deptIdList = new ArrayList<>();

    private List<SysFunc> menus = new ArrayList<>();

    /**
     * 将ActiveUser对象转换成SysUsery对象
     *
     * @return SysUser
     */
    public SysUser convertToUser() {
        ActiveUser.ActiveUserConvert userDTOConvert = new ActiveUser.ActiveUserConvert();
        return userDTOConvert.doForward(this);
    }

    /**
     * 将SysUser对象转换成ActiveUser对象
     *
     * @param user SysUser
     * @return ActiveUser
     */
    public ActiveUser convertFrom(SysUser user) {
        ActiveUser.ActiveUserConvert userDTOConvert = new ActiveUser.ActiveUserConvert();
        return userDTOConvert.doBackward(user);
    }

    /**
     * DTO与Entity相互转换的静态内部类
     */
    private static class ActiveUserConvert implements Converter<SysUser, ActiveUser> {

        @Override
        public SysUser doForward(ActiveUser dto) {
            SysUser user = new SysUser();
            BeanUtils.copyProperties(dto, user);
            return user;
        }

        @Override
        public ActiveUser doBackward(SysUser user) {
            ActiveUser dto = new ActiveUser();
            BeanUtils.copyProperties(user, dto);
            return dto;
        }

    }



}
