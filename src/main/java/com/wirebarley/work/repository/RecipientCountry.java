package com.wirebarley.work.repository;

import com.wirebarley.work.dto.CountryDto;

import java.util.List;

public interface RecipientCountry {
    List<CountryDto> findByAll();
}
