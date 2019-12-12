package com.lucas.mp.demo.dao;

import com.lucas.mp.demo.entity.SysFunc;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 系统_功能管理 Mapper 接口
 * </p>
 *
 * @author lucas
 * @since 2019-11-29
 */
public interface SysFuncDao extends BaseMapper<SysFunc> {

    /**
     * 根据用户ID查询关联的功能ID
     * @param userId  用户ID
     * @return 功能ID
     */
    List<Long> selectFunctionIds(@Param("userId") Long userId);
}
