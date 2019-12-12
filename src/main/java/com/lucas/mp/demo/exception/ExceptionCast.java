package com.lucas.mp.demo.exception;


/**
 * 抛自定义异常的静态方法
 *
 * @author Lucas
 * @version 0.0.1
 * @date 2019/11/12
 */
public class ExceptionCast {

    public static void cast(ExceptionCode resultCode) {
        throw new CustomException(resultCode);
    }

    public static void cast(int code, String msg) {
        throw new CustomException(code, msg);
    }

}
