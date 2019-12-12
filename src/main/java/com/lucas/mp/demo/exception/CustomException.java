package com.lucas.mp.demo.exception;

/**
 * 自定义异常
 *
 * @author Lucas
 */
public class CustomException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private int code;
    private String msg;

    CustomException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    CustomException(ExceptionCode exceptionEnum) {
        this.code = exceptionEnum.code();
        this.msg = exceptionEnum.msg();
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
