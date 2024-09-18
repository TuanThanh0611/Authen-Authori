package com.Ivo.Gym.service.exception;

public enum ErrorCode {
    User_EXISTED(1010,"USER_EXISTED"),
    INVALID_KEY(1001, "Uncategorized error"),
    USER_NOT_EXISTED(1009, "User not existed"),
    Invalid_Password(1006,"Password invalid"),
    UserName_InVAlid(1005,"User name invalid"),
    UNCATEGORIZED_EXCEPTION(9999,"Uncategorized error"),
    PASSWORD_NOTMATCH(1111,"PASSWORD_NOTMATCH")
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
