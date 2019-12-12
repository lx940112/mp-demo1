package com.lucas.mp.demo.enums;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @author liuxu
 */
//@Getter
public enum UserStatusEnum {

    /**
     * 正常
     */
    NORMAL("0"),
    /**
     * 停用
     */
    DISABLE("1"),
    /**
     * 冻结
     */
    FREEZE("2");

    @EnumValue
    private String value;

    UserStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }


}
