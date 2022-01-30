package com.wirebarley.work.controller.exchangeRate.api;

import com.wirebarley.work.service.exchangeRate.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExchangeRateApiController {
    private final ExchangeRateService exchangeRateService;

    @PostMapping(value="/ajax/requestExchangeRate")
    public ResponseEntity<?> exchangeRateMain(Model model) {
        return null;
    }
}
