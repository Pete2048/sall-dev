package com.qin.lily.core;

import com.qin.lily.exception.http.HttpException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.List;

/*
    CheckedException:编码必须解决的异常
    RuntimeException:运行时异常
 */
@ControllerAdvice
public class GlobalExceptionAdvice {
//    处理未知异常 返回 不返回e中信息（含敏感信息）
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)//500
    public UnifyResponse handleException(HttpServletRequest request,Exception e){
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        System.out.println(e);
        UnifyResponse message = new UnifyResponse(9999,"服务器异常",requestURI+"m"+method);
        return message;
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)//400
    public UnifyResponse handleBeanValidation(HttpServletRequest request,MethodArgumentNotValidException e){
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        System.out.println(e);
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        String message = formatAllErrorMessage(errors);
        return new UnifyResponse(10001,message,method+" "+requestURI);
    }
    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)//400
    public UnifyResponse handleConstraintViolationException(HttpServletRequest request,ConstraintViolationException e){
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
       /* for (ConstraintViolation constraintViolation:e.getConstraintViolations()
             ) {
            String message = constraintViolation.getMessage();
        }*/
        String message = e.getMessage();
       // String message = formatAllErrorMessage(errors);
        return new UnifyResponse(10001,message,method+" "+requestURI);
    }

    private String formatAllErrorMessage(List<ObjectError> errors) {
        StringBuffer errorMsg = new StringBuffer();
        errors.forEach(error ->
                        errorMsg.append(error.getDefaultMessage()).append(';')
                );
        return errorMsg.toString();
    }

    //    处理已知异常（message）
    @ExceptionHandler(value = HttpException.class)
    public void handleHttpException(HttpServletRequest request,HttpException e){
        System.out.println("hello,Exception。");
    }
}
