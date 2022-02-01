package com.wirebarley.work.repository;

import com.wirebarley.work.dto.RecipientCountryDto;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FixMemoryRecipientCountry implements RecipientCountry{
    final static List<RecipientCountryDto> memoryCountry = new ArrayList<>();
    @Override
    public List<RecipientCountryDto> findByAll() {
        if(memoryCountry.isEmpty()){
            memoryCountry.add(RecipientCountryDto.newKrw());
            memoryCountry.add(RecipientCountryDto.newJpy());
            memoryCountry.add(RecipientCountryDto.newPhp());
        }else{
            return memoryCountry;
        }
        return memoryCountry;
    }

    @PostConstruct
    public void init(){
        memoryCountry.clear();
    }
}
