package com.lucas.mp.demo.exception;

import com.google.common.collect.ImmutableMap;
import com.lucas.mp.demo.enums.CommonCode;
import com.lucas.mp.demo.vo.response.RespResult;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;

/**
 * 统一异常捕获类
 *
 * @author Lucas
 * @version 0.0.1
 * @date 2019/11/12
 */
@RestControllerAdvice
public class ExceptionCatch {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionCatch.class);

    /**
     * 定义map，配置异常类型所对应的错误代码
     */
    private static ImmutableMap<Class<? extends Throwable>, ExceptionCode> EXCEPTIONS;
    /**
     * 定义map的builder对象，去构建ImmutableMap
     */
    private static ImmutableMap.Builder<Class<? extends Throwable>, ExceptionCode> builder = ImmutableMap.builder();

    static {
        //定义异常类型所对应的错误代码
        builder.put(HttpMessageNotReadableException.class, CommonCode.INVALID_PARAM);
        builder.put(HttpRequestMethodNotSupportedException.class, CommonCode.REQUEST_METHOD_NOT_SUPPORT);

    }

    /**
     * 捕获自定义异常
     */
    @ExceptionHandler(CustomException.class)
    public RespResult handleCustomException(CustomException exception) {
        return RespResult.FAILED(exception.getCode(), exception.getMsg());
    }

    /**
     * 捕获Exception类异常
     */
    @ExceptionHandler(Exception.class)
    public RespResult handleException(Exception exception) {
        //记录日志
        LOGGER.error("catch exception:{}", exception.getMessage());
        if (EXCEPTIONS == null) {
            //构建EXCEPTIONS
            EXCEPTIONS = builder.build();
        }

        BindingResult result = null;
        if (exception instanceof MethodArgumentNotValidException) {
            result = ((MethodArgumentNotValidException) exception).getBindingResult();
        } else if (exception instanceof BindException) {
            result = ((BindException) exception).getBindingResult();
        } else if (exception instanceof ConstraintViolationException) {
            Set<ConstraintViolation<?>> constraintViolations = ((ConstraintViolationException) exception).getConstraintViolations();
            List<String> errors = newArrayList();
            constraintViolations.forEach(x -> errors.add(x.getMessage()));
            System.err.println(errors.toString());
        }
        if (result != null) {
            List<String> errors = newArrayList();
            result.getAllErrors().forEach(x -> errors.add(x.getDefaultMessage()));
            System.err.println(errors.toString());
            String errorMsg = errors.stream().filter(x -> x.contains("不能为空")).collect(Collectors.joining(","));
            if (StringUtils.isNotBlank(errorMsg)) {
                return RespResult.FAILED(CommonCode.NOTNULL_PARAM.code(), errorMsg);
            }
        }

        //从EXCEPTIONS中找异常类型所对应的错误代码，如果找到了将错误代码响应给用户，如果找不到给用户响应99999异常
        ExceptionCode resultCode = EXCEPTIONS.get(exception.getClass());
        if (resultCode == null) {
            resultCode = CommonCode.SERVER_ERROR;
        }
        return RespResult.FAILED(resultCode);
    }

}
