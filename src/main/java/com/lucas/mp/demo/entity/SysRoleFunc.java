package com.lucas.mp.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统_角色_功能
 * </p>
 *
 * @author lucas
 * @since 2019-11-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_role_func")
public class SysRoleFunc implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 关系ID
     */
    private Long id;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 功能ID
     */
    private Long funcId;

    /**
     * 创建人
     */
    private Long createUser;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
