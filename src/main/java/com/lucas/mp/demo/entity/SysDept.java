package com.lucas.mp.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统_部门管理
 * </p>
 *
 * @author lucas
 * @since 2019-11-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_dept")
public class SysDept implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 上级ID
     */
    private Long parentId;

    /**
     * 所有上级ID，用逗号分开
     */
    private String parentIds;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 描述
     */
    private String deptDesc;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 删除标识:1-未删除; 0-删除
     */
    private Integer delFlag;

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
