package com.wirebarley.work.adapter;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.math.BigInteger;

@Getter
@Setter
public class ReqExchangeDto {
    @NotBlank(message = "수취 국가는 공백일 수 없습니다.")
    private String recipientCountry;

    private BigInteger amount;

}
