package com.wirebarley.work.handler;

import com.wirebarley.work.common.ResCode;
import com.wirebarley.work.dto.CMResDto;
import com.wirebarley.work.handler.ex.CustomApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(CustomApiException.class)
    public ResponseEntity<?> CustomApiException(CustomApiException e) {
        return new ResponseEntity<>(new CMResDto<>(ResCode.REQUEST_FALL.getCode(),ResCode.REQUEST_FALL.getValue(), e), HttpStatus.BAD_REQUEST);
    }
}
