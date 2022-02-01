package com.wirebarley.work.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class RecipientCountryDto {
    private String recipientCountryName;
    private String recipientCountry;

    private RecipientCountryDto(String recipientCountryName, String recipientCountry) {
        this.recipientCountryName = recipientCountryName;
        this.recipientCountry = recipientCountry;
    }

    public static RecipientCountryDto newKrw() { //
        return new RecipientCountryDto("한국(KRW)","KRW");
    }

    public static RecipientCountryDto newJpy() { //
        return new RecipientCountryDto("일본(JPY)","JPY");
    }

    public static RecipientCountryDto newPhp() { //
        return new RecipientCountryDto("필리민(PHP)","PHP");
    }
}
