package com.lucas.mp.demo.exception;

/**
 * @author Lucas
 * 10000-- 通用错误代码
 * 22000-- 模块错误代码
 * 23000-- 模块错误代码
 * 24000-- 模块错误代码
 * ......
 */

public interface ExceptionCode {
    /**
     * 获取错误代码
     * @return 错误代码
     */
    int code();
    /**
     * 获取错误信息
     * @return 错误信息
     */
    String msg();
}
