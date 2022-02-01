package com.wirebarley.work.controller.exchangeRate;

import com.wirebarley.work.service.exchangeRate.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ExchangeRateController {
    private final ExchangeRateService exchangeRateService;

    @GetMapping(value = {"/","/exchange"})
    public String exchangeRateMain(Model model) {
        model.addAttribute("recipientCountryList",exchangeRateService.findByAll());
        return "/exchange/exchangeRateMain";
    }
}
