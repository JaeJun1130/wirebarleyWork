package com.wirebarley.work.repository;

import com.wirebarley.work.dto.RecipientCountryDto;

import java.util.List;

public interface RecipientCountry {
    List<RecipientCountryDto> findByAll();
}
