package pl.coderslab.accountsview.currency.apinbp;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;


@RequestMapping("/api/nbp")
@RestController
@RequiredArgsConstructor
public class ApiNbpController {

    private final ApiNbpClient apiNbpClient;

    @GetMapping("/{currency}")
    public NbpDto getRate(@PathVariable String currency) {
        return apiNbpClient.getRate(currency);
    }

    @GetMapping("/{currency}/{count}")
    public RateDto getRateOfDay(@PathVariable String currency, @PathVariable int count) {
        List<RateDto> currencies = new CopyOnWriteArrayList<>();
        List<CompletableFuture<Boolean>> results = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int finalI = i;
            CompletableFuture<Boolean> currencyResult = apiNbpClient.getRateOfDay(currency, count).thenApply(rateDto -> currencies.add(rateDto.rateDto().get(finalI)));
            results.add(currencyResult);
        }
        CompletableFuture.allOf(results.toArray(new CompletableFuture[0])).join();

        return Collections.max(currencies, Comparator.comparing(RateDto::mid));
    }
}
