package com.wirebarley.work.adapter;

import com.wirebarley.work.handler.ex.CustomApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class ExchangeApi {
    private final WebClient webClient;

    public ResExchangeDto send() throws Exception {
        try {
            ResExchangeDto resDto = webClient.get().
                    uri(uri -> uri.queryParam("access_key", "80854038bedf5f85838d387a0d26649c")
                            .queryParam("currencies", "KRW")
                            .queryParam("source", "USD")
                            .queryParam("format", "1")
                            .build()
                    )
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToFlux(ResExchangeDto.class).blockLast();

//            ObjectMapper mapper = new ObjectMapper();
//            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); //파라미터Map에서 DTO에 들어있지 않는 변수가 있어도 무시함.
//            ResExchangeDto resExchangeDto = mapper.convertValue(resDto, ResExchangeDto.class);
//            System.out.println("resExchangeDto = " + resExchangeDto.toString());
            return resDto;
        } catch (Exception e){
            e.printStackTrace();
            throw new CustomApiException(e.getMessage());
        }
    }
}
