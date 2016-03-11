package com.silvermining.demo.exception;

/**
 * Created by pooldolorier on 11/03/16.
 */
public enum ExceptionMessageEnum {
    MENU_BUSINESS_EXCPTION(1, "Menu business error");

    private int code;
    private String message;

    ExceptionMessageEnum(int code, String message) {
        this.code = code;
        this.message = message;
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
