package com.dingli.javaee.bean;

public class MyResponse<T> {
    // 表示当前请求是否成功
    private boolean success;
    // 当前请求返回的消息
    private String msg;
    // 表示状态码
    private int status;
    // 表示业务码
    private int bizCode;
    // 返回的数据对象
    private T content;

    private MyResponse() {
    }

    public static final <T> MyResponse<T> success() {
        MyResponse<T> response = new MyResponse();
        response.setSuccess(true);
        response.setStatus(200);
        return response;
    }

    public static final <T> MyResponse<T> success(String msg) {
        MyResponse<T> response = success();
        response.setMsg(msg);
        return response;
    }

    public static final <T> MyResponse<T> success(T content) {
        MyResponse response = success();
        response.setContent(content);
        return response;
    }

    public static final <T> MyResponse<T> success(String msg, T content) {
        MyResponse response = success();
        response.setContent(content);
        response.setMsg(msg);
        return response;
    }

    public static final <T> MyResponse<T> error(String msg) {
        MyResponse<T> response = new MyResponse();
        response.setMsg(msg);
        response.setSuccess(false);
        response.setStatus(500);
        return response;
    }

    public static final <T> MyResponse<T> error(String msg, int bizCode) {
        MyResponse<T> response = error(msg);
        response.setBizCode(bizCode);
        return response;
    }

    public static final <T> MyResponse<T> error(String msg, T content) {
        MyResponse<T> response = error(msg);
        response.setContent(content);
        return response;
    }

    public static final <T> MyResponse<T> error(String msg, T content, int bizCode) {
        MyResponse<T> response = error(msg);
        response.setContent(content);
        response.setBizCode(bizCode);
        return response;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getBizCode() {
        return this.bizCode;
    }

    public void setBizCode(int bizCode) {
        this.bizCode = bizCode;
    }

    public T getContent() {
        return this.content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
