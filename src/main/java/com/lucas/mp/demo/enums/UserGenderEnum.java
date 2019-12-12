package com.lucas.mp.demo.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @author liuxu
 */
@Getter
public enum UserGenderEnum {
    /**
     * 女
     */
    FEMALE(0),
    /**
     * 男
     */
    MALE(1),
    /**
     * 女
     */
    OTHER(2);

    @EnumValue
    private int value;

    UserGenderEnum(int value) {
        this.value = value;
    }

    private int value() {
        return this.value;
    }

}
