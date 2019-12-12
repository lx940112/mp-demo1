package com.lucas.mp.demo.enums;

public enum FuncTypeEnum {
    /**
     * 菜单
     */
    MENU(0),
    /**
     * 按钮
     */
    BUTTON(1);

    private int value;

    FuncTypeEnum(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
