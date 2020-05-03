package com.qin.lily.core;

import com.qin.lily.exception.http.HttpException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
/*
    CheckedException:编码必须解决的异常
    RuntimeException:运行时异常
 */
@ControllerAdvice
public class GlobalExceptionAdvice {
//    处理未知异常 返回 不返回e中信息（含敏感信息）
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public UnifyResponse handleException(HttpServletRequest request,Exception e){
        UnifyResponse message = new UnifyResponse(9999,"服务器异常","url");
        return message;
    }
//    处理已知异常（message）
    @ExceptionHandler(value = HttpException.class)
    public void handleHttpException(HttpServletRequest request,HttpException e){
        System.out.println("hello,Exception。");
    }
}
