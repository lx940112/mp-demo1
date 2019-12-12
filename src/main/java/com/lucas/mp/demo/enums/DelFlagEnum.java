package com.lucas.mp.demo.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @author liuxu
 */
@Getter
public enum DelFlagEnum {

    /**
     * 已删除
     */
    YES(1),
    /**
     * 未删除
     */
    NO(0);

    @EnumValue
    private int value;

    DelFlagEnum(int value) {
        this.value = value;
    }

    private int value() {
        return this.value;
    }

}
