package com.example.adapter.out;


import com.example.common.exception.ErrorCode;
import com.example.common.exception.HexagonException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HexagonErrorAdapter {

    @ExceptionHandler({ HexagonException.class })
    private ResponseEntity<ErrorCode> hexagonException(HexagonException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(e.getErrorCode());
    }
}
