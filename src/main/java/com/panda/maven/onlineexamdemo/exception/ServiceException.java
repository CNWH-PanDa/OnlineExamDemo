package com.panda.maven.onlineexamdemo.exception;

public class ServiceException extends RuntimeException{

    private Integer code;

    public ServiceException(String message) {
        super(message);
    }

    public Integer getCode() {
        return code;
    }

    public ServiceException(Integer code, String message) {
        super(message);
        this.code = code;
    }

}
