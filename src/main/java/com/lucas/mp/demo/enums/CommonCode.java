package com.lucas.mp.demo.enums;


import com.lucas.mp.demo.exception.ExceptionCode;

/**
 * 自定义的通用异常，
 *
 * @author Lucas
 */

public enum CommonCode implements ExceptionCode {

    /**
     * 操作失败
     */
    FAIL(10001,"操作失败！"),
    /**
     * 未登录异常
     */
    UNAUTHENTICATED(10002,"此操作需要登陆系统！"),
    /**
     * 权限不足异常
     */
    UNAUTHORIZED(10003,"权限不足，无权操作！"),
    /**
     * 非法参数异常
     */
    INVALID_PARAM(10004,"非法参数！"),
    /**
     * 参数不能为空异常
     */
    NOTNULL_PARAM(10005,"参数不能为空！"),
    /**
     * 不支持当前http方法
     */
    REQUEST_METHOD_NOT_SUPPORT(10006,"不支持当前http方法！"),
    /**
     * 系统繁(异)忙(常)
     */
    SERVER_ERROR(99999,"抱歉，系统繁忙，请稍后重试！");

    private int code;
    private String msg;


    CommonCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    @Override
    public int code(){
        return this.code;
    }
    @Override
    public String msg(){
        return this.msg;
    }
}
