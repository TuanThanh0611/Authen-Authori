package com.Ivo.Auth.exception;

public enum ErrorCode {
    User_EXISTED(101,"USER_EXISTED"),
    INVALID_KEY(1002, "Uncategorized error"),
    USER_NOT_EXISTED(1003, "User not existed"),
    Invalid_Password(1004,"Password invalid"),
    UserName_InVAlid(1005,"User name invalid"),
    UNCATEGORIZED_EXCEPTION(9999,"Uncategorized error"),
    PASSWORD_NOTMATCH(1006,"PASSWORD_NOTMATCH"),
    UNAUTHENTICATED(1007,"UNAUTHENTICATED"),
    CANNOT_CREATE_TOKEN(1008,"CANNOT_CREATE_TOKEN"),

    INVALID_TOKEN(1009,"INVALID_TOKEN")
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
