package com.wirebarley.work.service.currency;

import com.wirebarley.work.adapter.ResExchangeDto;

import java.math.BigDecimal;

public class UsdToKrwCurrency extends AbstractCurrency{
    @Override
    public  BigDecimal getCountryExchangeRate(ResExchangeDto resExchangeDto){
        return resExchangeDto.getQuotes().getUsdkrw();
    }
}
