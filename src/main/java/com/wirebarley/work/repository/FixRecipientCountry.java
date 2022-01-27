package com.wirebarley.work.repository;

import com.wirebarley.work.dto.CountryDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FixRecipientCountry implements RecipientCountry{
    final static List<CountryDto> memoryCountry = new ArrayList<>();
    @Override
    public List<CountryDto> findByAll() {
        memoryCountry.add(new CountryDto("한국(KRW)","KRW"));
        memoryCountry.add(new CountryDto("일본(JPY)","JPY"));
        memoryCountry.add(new CountryDto("필리민(PHP)","PHP"));
        return memoryCountry;
    }
}
