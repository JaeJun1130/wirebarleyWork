package com.wirebarley.work.service.currency;

import com.wirebarley.work.adapter.ResExchangeDto;

import java.math.BigDecimal;

public interface Currency {
    BigDecimal getCountryExchangeRate(ResExchangeDto resExchangeDto);

    BigDecimal calculate(int amount, ResExchangeDto exchangeRate);
}

