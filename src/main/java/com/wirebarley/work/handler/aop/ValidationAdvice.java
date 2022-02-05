package com.wirebarley.work.handler.aop;

import com.wirebarley.work.commons.ResCode;
import com.wirebarley.work.handler.ex.CustomValidationApiException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
@Aspect
public class ValidationAdvice {
    @Around("@annotation(com.wirebarley.work.commons.ApiValidationAdvice)")
    public Object apiAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof BindingResult) {
                BindingResult bindingResult = (BindingResult) arg;

                if (bindingResult.hasErrors()) {
                    Map<String, String> errorMap = new HashMap<>();
                    for (FieldError fieldError : bindingResult.getFieldErrors()) {
                        errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
                        log.error("fieldError.getDefaultMessage = {}",fieldError.getDefaultMessage());
                    }
                    throw new CustomValidationApiException(ResCode.VALIDATION_ERROR.getValue(), errorMap);
                }
            }
        }
        return proceedingJoinPoint.proceed();
    }
}
