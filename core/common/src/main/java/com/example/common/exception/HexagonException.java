package com.example.common.exception;
import lombok.Getter;

@Getter
public class HexagonException extends RuntimeException {
    private final ErrorCode errorCode;
    public HexagonException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}