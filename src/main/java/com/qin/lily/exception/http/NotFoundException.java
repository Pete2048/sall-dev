package com.qin.lily.exception.http;

/**
 * 404异常处理
 */
public class NotFoundException extends  HttpException {
    public NotFoundException(int code) {
        this.code = code;
        this.httpStatusCode = 404;
    }
}
