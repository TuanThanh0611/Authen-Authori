package com.Ivo.Gym.service.exception;

public enum ErrorCode {
    User_EXISTED(1010,"USER_EXISTED")
    ;
    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
