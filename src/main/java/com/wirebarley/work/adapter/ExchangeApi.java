package com.wirebarley.work.adapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wirebarley.work.common.ResCode;
import com.wirebarley.work.handler.ex.CustomApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class ExchangeApi {
    private final WebClient webClient;

    @Value("${api.accessKey}")
    private String accessKey;

    private static Map<String, ResExchangeDto> dataMap = new ConcurrentHashMap<>();

    private ResExchangeDto send(ReqExchangeDto reqExchangeDto) {
        try {
            ResExchangeDto resExchangeDto = webClient.get().
                    uri(uri -> uri.queryParam("access_key", accessKey)
                            .queryParam("currencies", reqExchangeDto.getRecipientCountry())
                            .queryParam("source", "USD")
                            .queryParam("format", "1")
                            .build()
                    )
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .onStatus(HttpStatus::is4xxClientError, response -> Mono.error(() -> new CustomApiException(ResCode.REQUEST_API_FALL.getValue())))
                    .onStatus(HttpStatus::is5xxServerError, response -> Mono.error(() -> new CustomApiException(ResCode.REQUEST_API_FALL.getValue())))
                    .bodyToFlux(ResExchangeDto.class)
                    .blockFirst();

            if(resExchangeDto == null || "false".equals(resExchangeDto.getSuccess())) throw new CustomApiException(ResCode.REQUEST_API_FALL.getValue());
            
            dataMap.putIfAbsent(CACHE_KEY + reqExchangeDto.getRecipientCountry(),resExchangeDto);
            return dataMap.get(CACHE_KEY + reqExchangeDto.getRecipientCountry());
        } catch (Exception e){
            e.printStackTrace();
            throw new CustomApiException(e.getMessage());
        }
    }

    public ResExchangeDto getExchangeRate(ReqExchangeDto reqExchangeDto) {
        ResExchangeDto cachedData = dataMap.get(CACHE_KEY + reqExchangeDto.getRecipientCountry());

        if(cachedData == null) {
            log.info("cache 데이터가 아님");
            return send(reqExchangeDto);
        } else {
            log.info("cache 데이터 사용됨");
            return cachedData;
        }
    }

    //1분마다 캐시 비움
    @Scheduled(cron = "0 */1 * * * *")
    public void refreshCache() {
        log.info("cache deleted");
        dataMap.clear();
    }
}