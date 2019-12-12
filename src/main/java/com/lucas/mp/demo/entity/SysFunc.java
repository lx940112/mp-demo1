package com.lucas.mp.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统_功能管理
 * </p>
 *
 * @author lucas
 * @since 2019-11-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_func")
public class SysFunc implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 功能ID
     */
    private Long id;

    /**
     * 功能代码
     */
    private String funcCode;

    /**
     * 功能名称
     */
    private String funcName;

    /**
     * 父级功能ID,一级菜单为0
     */
    private Long parentId;

    /**
     * 功能描述
     */
    private String funcDesc;

    /**
     * 请求方式（如：GET、POST、PUT、DELETE）
     */
    private String funcMethod;

    /**
     * 功能URL
     */
    private String funcUrl;

    /**
     * 图标
     */
    private String funcIcon;

    /**
     * 功能备注
     */
    private String remark;

    /**
     * 功能类型：0-菜单,1-按钮
     */
    private Integer funcType;

    /**
     * 认证等级：0-权限认证;1-登录认证;2-无需认证
     */
    private Integer authLevel;

    /**
     * 删除标识:1-未删除; 0-删除
     */
    private Integer delFlag;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 打开链接
     */
    private String target;

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
