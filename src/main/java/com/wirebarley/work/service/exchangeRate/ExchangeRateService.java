package com.wirebarley.work.service.exchangeRate;

import com.wirebarley.work.dto.CountryDto;

import java.util.ArrayList;
import java.util.List;

public interface ExchangeRateService {
    List<CountryDto> findByAll();
}
