package com.example.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    BAD_PARAMETER(HttpStatus.BAD_REQUEST, -4000, "argument_badrequest"),
    EXIST_NICKNAME(HttpStatus.BAD_REQUEST, -4000, "exist_nickname"),
    NOT_FOUND_MEMBER(HttpStatus.BAD_REQUEST, -4001, "not_found_member"),
    SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, -5000, "server_error");

    private final HttpStatus httpStatus;
    private final int code;
    private final String message;

    ErrorCode(HttpStatus httpStatus, int code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }
}