package com.comb.exceptions;

/**
 * Created by Administrator on 2016/7/28.
 */
public class CommonsException extends RuntimeException {

    public int status = 500;

    public CommonsException() {
        super();
    }

    public CommonsException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommonsException(String message) {
        super(message);
    }

    public CommonsException(Throwable cause) {
        super(cause);
    }

    public CommonsException(int statusCode) {
        super();
        this.status= statusCode;
    }

    public CommonsException(int statusCode, String message, Throwable cause) {
        super(message, cause);
        this.status = statusCode;
    }

    public CommonsException(int statusCode, String message) {
        super(message);
        this.status = statusCode;
    }

    public CommonsException(int statusCode, Throwable cause) {
        super(cause);
        this.status = statusCode;
    }

}
