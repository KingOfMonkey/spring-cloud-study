package com.meiya.springcloudstudy.common.enums;

public enum  ResponseEnum {

    SUCCESS(200, "请求成功"),

    FAIL(401, "请求失败"),

    SERVICE_EXCEPTION(210, "业务异常"),

    SERVER_EXCEPTION(500, "服务端异常, 请联系管理员!");

    private Integer code;

    private String message;

    ResponseEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
