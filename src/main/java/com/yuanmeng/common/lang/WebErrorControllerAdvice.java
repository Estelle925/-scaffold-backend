package com.yuanmeng.common.lang;


import com.yuanmeng.common.lang.enums.ResultCode;
import com.yuanmeng.common.lang.exception.RdosDefineException;
import com.yuanmeng.common.lang.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;

/**
 * @author chenhaiming
 */
@RestControllerAdvice
@EnableWebMvc
@Order
public class WebErrorControllerAdvice {
    public static final Logger log = LoggerFactory.getLogger(WebErrorControllerAdvice.class);

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Result<String> notFound(HttpServletRequest request, NoHandlerFoundException e) {
        if (log.isWarnEnabled()) {
            log.warn("请求路径不存在", e);
        }
        return Result.error(ResultCode.NOT_FOUND_ERROR);
    }

    @ResponseBody
    @ExceptionHandler(BindException.class)
    public Result<?> handleValidationException(BindException e) {
        return Result.error(ResultCode.INVALID_PARAMETERS.getCode(), validateMessage(e.getBindingResult()));
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return Result.error(ResultCode.INVALID_PARAMETERS.getCode(), validateMessage(e.getBindingResult()));
    }

    private static String validateMessage(BindingResult bindingResult) {
        return bindingResult.getFieldErrors()
                .stream().map(f -> String.format("%s : %s", f.getField(), f.getDefaultMessage()))
                .collect(Collectors.joining("，"));
    }

    @ExceptionHandler(RdosDefineException.class)
    @ResponseStatus(HttpStatus.OK)
    public Result<String> bizException(RdosDefineException e) {
        if (log.isErrorEnabled()) {
            log.error("请求执行出现业务异常", e);
        }
        return Result.error(ResultCode.ERROR.getCode(), e.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<?> systemException(Throwable e) {
        if (log.isErrorEnabled()) {
            log.error("请求执行出现未知系统异常", e);
        }
        return Result.error(ResultCode.SERVER_INTERNAL_ERROR).message(e.getMessage());
    }

    @ExceptionHandler(HttpMessageConversionException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<?> jsonException(HttpMessageConversionException e) {
        if (log.isWarnEnabled()) {
            log.warn("异常HTTP解码", e);
        }
        return Result.error(ResultCode.INVALID_PARAMETERS);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.OK)
    public Result<?> illegalException(IllegalArgumentException e) {
        if (log.isWarnEnabled()) {
            log.warn("参数异常", e);
        }
        return Result.error(ResultCode.INVALID_PARAMETERS).message(e.getMessage());
    }
}
