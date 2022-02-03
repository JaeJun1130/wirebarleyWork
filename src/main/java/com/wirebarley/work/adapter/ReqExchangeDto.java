package com.wirebarley.work.adapter;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ReqExchangeDto {
    @NotBlank(message = "수취 국가는 공백일 수 없습니다.")
    private String recipientCountry;

    @Min(value = 1, message = "송금액은 0원 이상 값만 입력할 수 있습니다.")
    @Max(value = 10000, message = "송금액은 10,000 이하 값만 입력할 수 있습니다.")
    private int amount;
}
