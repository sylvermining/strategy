package com.silvermining.demo.exception;

/**
 * Created by pooldolorier on 11/03/16.
 */
public class BusinessException extends StrategyException {


    public BusinessException(int code, String message) {
        super(code, message);
    }
}
