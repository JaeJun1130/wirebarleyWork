package com.wirebarley.work.service.currency;

import com.wirebarley.work.adapter.ResExchangeDto;

import java.math.BigDecimal;

public abstract class AbstractCurrency implements Currency{

    public final BigDecimal calculate(int amount, ResExchangeDto resExchangeDto) {
        BigDecimal exchangeRate = getCountryExchangeRate(resExchangeDto);
        return exchangeRate.multiply(BigDecimal.valueOf(amount));
    }
}
