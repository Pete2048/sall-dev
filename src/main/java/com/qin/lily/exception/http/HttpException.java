package com.qin.lily.exception.http;

public class HttpException extends RuntimeException{
    protected Integer code;
    protected Integer httpStatusCode=500;

}
