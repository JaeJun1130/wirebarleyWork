package com.wirebarley.work.service.exchangeRate;

import com.wirebarley.work.adapter.ExchangeApi;
import com.wirebarley.work.adapter.ReqExchangeDto;
import com.wirebarley.work.adapter.ResExchangeDto;
import com.wirebarley.work.service.AbstractCurrency;
import com.wirebarley.work.service.Currency;
import com.wirebarley.work.service.CurrencyFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ExchangeCalculation {
    private final ExchangeApi exchangeApi;

    public BigDecimal calculation(ReqExchangeDto reqExchangeDto){
        ResExchangeDto exchangeRate = exchangeApi.getExchangeRate(reqExchangeDto);
        Currency currency = CurrencyFactory.create(reqExchangeDto.getRecipientCountry());
        return currency.calculate(reqExchangeDto.getAmount(), exchangeRate);
    }
}
