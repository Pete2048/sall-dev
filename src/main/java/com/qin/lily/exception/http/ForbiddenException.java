package com.qin.lily.exception.http;

/**
 *权限异常处理
 */
public class ForbiddenException extends  HttpException {
    /**
     *
     * @param code
     */
    public ForbiddenException(int code) {
        this.code = code;
//        没有权限
        this.httpStatusCode = 403;
    }
}
