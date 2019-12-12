package com.lucas.mp.demo.vo.response;

import com.lucas.mp.demo.exception.ExceptionCode;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author Lucas
 * @date 2019/11/12
 */
@Data
@ToString
@NoArgsConstructor
public class RespResult<T> implements Response {

    private static final long serialVersionUID = 1L;

    /**操作是否成功*/
    private boolean success = SUCCESS;

    /**操作代码*/
    private int code = SUCCESS_CODE;

    /**提示信息*/
    private String message;
    private T data;

    public  RespResult<T> ok(T data) {
        this.setData(data);
        return this;
    }

    private RespResult(int code, String msg) {
        this.success = FAIL;
        this.code = code;
        this.message = msg;
    }

    private RespResult(ExceptionCode resultCode){
        this.success = FAIL;
        this.code = resultCode.code();
        this.message = resultCode.msg();
    }



    public static RespResult SUCCESSED(){
        return new RespResult();
    }

    public static RespResult FAILED (ExceptionCode resultCode){
        return new RespResult(resultCode);
    }

    public static RespResult FAILED (int code, String msg){
        return new RespResult(code,msg);
    }

}
