package com.silvermining.demo.exception;

/**
 * Created by pooldolorier on 11/03/16.
 */
public class StrategyException extends RuntimeException {

    private int code;
    private String message;

    public StrategyException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
