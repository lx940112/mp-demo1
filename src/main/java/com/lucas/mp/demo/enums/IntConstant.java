package com.lucas.mp.demo.enums;


import lombok.Getter;

/**
 * @author Lucas
 */
@Getter
public enum IntConstant {

    /**
     * 当前登录用户名
     */
    ACTIVE_USER_SESSION("activeUser");


    private String value;

    IntConstant(String value) {
        this.value = value;
    }

}
