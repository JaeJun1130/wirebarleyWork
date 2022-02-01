package com.wirebarley.work.service.exchangeRate;

import com.wirebarley.work.dto.RecipientCountryDto;

import java.util.List;

public interface ExchangeRateService {
    List<RecipientCountryDto> findByAll();
}
