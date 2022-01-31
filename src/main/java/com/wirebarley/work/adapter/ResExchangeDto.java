package com.wirebarley.work.adapter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResExchangeDto {
    private String success;
    private String timestamp;
    private String source;
    private Quotes quotes;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    class Quotes {
        @JsonProperty("USDKRW")
        private BigDecimal usdKrw;

        @JsonProperty("USDJPY")
        private BigDecimal usdJpy;

        @JsonProperty("USDPHP")
        private BigDecimal usdPhp;
    }
}
