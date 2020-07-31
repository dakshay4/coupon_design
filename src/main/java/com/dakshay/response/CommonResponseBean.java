package com.dakshay.response;

/**
 * Created by Dakshay on 9/23/2018.
 */
public class CommonResponseBean {
    private int code;
    private String message;

    public CommonResponseBean() {
    }
    public CommonResponseBean(String errorMessage) {
        this.message = errorMessage;
    }

    public CommonResponseBean(int code, String errorMessage) {
        this.code = code;
        this.message = errorMessage;
    }

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
}
