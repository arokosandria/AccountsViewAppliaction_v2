package pl.coderslab.accountsview.currencycheduled;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.coderslab.accountsview.currency.apinbp.ApiNbpClient;
import pl.coderslab.accountsview.currency.Currency;
import pl.coderslab.accountsview.currency.CurrencyRepository;
import pl.coderslab.accountsview.currency.CurrencyService;

import java.util.List;
@Component
@Slf4j
@RequiredArgsConstructor
public class CurrencyScheduled {
    private final CurrencyRepository currencyRepository;
    private final ApiNbpClient apiNbpClient;
    private final CurrencyService currencyService;

    @Scheduled(cron = "${app.currency-job.cron}")
    public void every30SecondsReadCurrency() {
        log.info("Currency write start");
        currencyService.delete();
        List<String> currencies=List.of("USD","CHF","NOK","RON","SEK");
        for (String currency : currencies) {
            Currency currency1 =
                    Currency.builder()
                            .currency(currency)
                            .mid(apiNbpClient.getRate(currency).rateDto().get(0).mid())
                            .build();
            currencyRepository.save(currency1);
        }
        log.info("Currency write done");

    }
}
