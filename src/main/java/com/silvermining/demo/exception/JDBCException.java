package com.silvermining.demo.exception;

/**
 * Created by pooldolorier on 11/03/16.
 */
public class JDBCException extends StrategyException {
    public JDBCException(int code, String message) {
        super(code, message);
    }
}
