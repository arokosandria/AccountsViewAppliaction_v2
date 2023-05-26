package pl.coderslab.accountsview.currency.apinbp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;


@Slf4j
@Service
@RequiredArgsConstructor
public class ApiNbpClient {

    private final RestTemplate restTemplate;

    @Value("${api.nbp.main-path}")
    private String apiPath;

    public NbpDto getRate(String currency) {
        String url = apiPath.concat("/a/{currency}");
        NbpDto rate = restTemplate.getForObject(url, NbpDto.class, currency);
        return rate;
    }

    @Async
    public CompletableFuture<NbpDto> getRateOfDay(String currency, int count) {
        String url = apiPath.concat("/a/{currency}/last/{count}");
        NbpDto rate = restTemplate.getForObject(url, NbpDto.class, currency, count);
        return CompletableFuture.completedFuture(rate);
    }

}