package com.epam.esm.task.exception;

public enum ExceptionCode {
    NOT_FOUND_EXCEPTION(42401,"NOT FOUND"),
    BAD_REQUEST(42404,"BAD REQUEST"),
    METHOD_NOT_ALLOWED(42501,"METHOD NOT ALLOWED");

    private final int code;
    private final String name;

    ExceptionCode(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
