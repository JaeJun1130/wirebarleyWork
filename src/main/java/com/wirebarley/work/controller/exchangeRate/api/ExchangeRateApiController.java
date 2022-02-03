package com.wirebarley.work.controller.exchangeRate.api;

import com.wirebarley.work.adapter.ExchangeApi;
import com.wirebarley.work.adapter.ReqExchangeDto;
import com.wirebarley.work.adapter.ResExchangeDto;
import com.wirebarley.work.common.ResCode;
import com.wirebarley.work.dto.CMResDto;
import com.wirebarley.work.handler.ex.CustomValidationApiException;
import com.wirebarley.work.service.exchangeRate.ExchangeCalculation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ExchangeRateApiController {
    private final ExchangeApi exchangeApi;
    private final ExchangeCalculation exchangeCalculation;

    @PostMapping(value="/ajax/requestExchangeRate")
    public ResponseEntity<?> exchangeRateMain(@RequestBody @Valid ReqExchangeDto reqExchangeDto,
                                              BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();

            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());

                log.info("fieldError.getDefaultMessage = {}",fieldError.getDefaultMessage());
            }
            throw new CustomValidationApiException(ResCode.VALIDATION_ERROR.getValue(), errorMap);
        }

        return new ResponseEntity<>(new CMResDto<>(ResCode.REQUEST_API_SUCCESS.getCode(), ResCode.REQUEST_API_SUCCESS.getValue(), exchangeApi.getExchangeRate(reqExchangeDto)), HttpStatus.OK);
    }

    @PostMapping(value="/ajax/requestExchangeRate/calculate")
    public ResponseEntity<?> exchangeRateCalculate(@RequestBody @Valid ReqExchangeDto reqExchangeDto,
                                                          BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();

            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());

                log.info("fieldError.getDefaultMessage = {}",fieldError.getDefaultMessage());
            }
            throw new CustomValidationApiException(ResCode.VALIDATION_ERROR.getValue(), errorMap);
        }

        return new ResponseEntity<>(new CMResDto<>(ResCode.REQUEST_API_SUCCESS.getCode(), ResCode.REQUEST_API_SUCCESS.getValue(), exchangeCalculation.calculation(reqExchangeDto)), HttpStatus.OK);
    }
}
