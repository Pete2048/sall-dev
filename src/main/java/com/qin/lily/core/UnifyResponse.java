package com.qin.lily.core;

/**
 * @description:统一处理异常
 * @author: Pete
 * @date: Created in 2020/5/3 10:39
 * @modified By:
 */
public class UnifyResponse {
    private int code;
    private String message;
    private String request;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public UnifyResponse(int code, String message, String request) {
        this.code = code;
        this.message = message;
        this.request = request;
    }
}
