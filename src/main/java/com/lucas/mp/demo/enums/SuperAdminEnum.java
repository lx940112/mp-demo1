package com.lucas.mp.demo.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 超级管理员枚举
 *
 * @author liuxu
 */
@Getter
public enum SuperAdminEnum {

    /**
     * 是超级管理员
     */
    YES(1),
    /**
     * 不是超级管理员
     */
    NO(0);

    @EnumValue
    private int value;

    SuperAdminEnum(int value) {
        this.value = value;
    }

    private int value() {
        return this.value;
    }

}
