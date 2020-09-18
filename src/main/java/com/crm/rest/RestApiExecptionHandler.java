package com.crm.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class RestApiExecptionHandler {

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    static class ErrorRes {

        Integer status;

        String message;

    }

    @ExceptionHandler({Exception.class})
    public final ResponseEntity<ErrorRes> handleException(Exception e) {
        log.error("handleException() ", e);
        final ErrorRes errorRes = ErrorRes
                .builder()
                .status(404)
                .message(e.getMessage())
                .build();
        return ResponseEntity.badRequest()
                .body(errorRes);
    }


}

