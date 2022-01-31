package com.wirebarley.work.controller.exchangeRate.api;

import com.wirebarley.work.common.ResCode;
import com.wirebarley.work.dto.CMResDto;
import com.wirebarley.work.adapter.ResExchangeDto;
import com.wirebarley.work.adapter.ExchangeApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExchangeRateApiController {
    private final ExchangeApi exchangeApi;

    @PostMapping(value="/ajax/requestExchangeRate")
    public ResponseEntity<?> exchangeRateMain() throws Exception {
        ResExchangeDto send = exchangeApi.send();
        return new ResponseEntity<>(new CMResDto<>(ResCode.REQUEST_SUCCESS.getCode(), ResCode.REQUEST_SUCCESS.getValue(), send), HttpStatus.OK);
    }
}

