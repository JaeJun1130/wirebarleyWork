package com.wirebarley.work.service.exchangeRate;

import com.wirebarley.work.dto.CountryDto;
import com.wirebarley.work.repository.RecipientCountry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private final RecipientCountry recipientCountry;

    @Override
    public List<CountryDto> findByAll() {
        return recipientCountry.findByAll();
    }
}
