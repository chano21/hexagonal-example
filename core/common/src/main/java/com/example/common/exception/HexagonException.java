package com.example.common.exception;
import lombok.Getter;

@Getter
public class HexagonException extends RuntimeException {
    private final ErrorCode responseStatusType;
    private String customMessage;

    public HexagonException(ErrorCode responseStatusType) {
        super(responseStatusType.getMessage());
        this.responseStatusType = responseStatusType;
    }

    public HexagonException(ErrorCode responseStatusType, Throwable t) {
        super(t);
        this.responseStatusType = responseStatusType;
    }

    public HexagonException(ErrorCode responseStatusType, String customMessage) {
        super(responseStatusType.getMessage());
        this.responseStatusType = responseStatusType;
        this.customMessage = customMessage;
    }

    public HexagonException(ErrorCode responseStatusType, Throwable t, String customMessage) {
        super(t);
        this.responseStatusType = responseStatusType;
        this.customMessage = customMessage;
    }

}