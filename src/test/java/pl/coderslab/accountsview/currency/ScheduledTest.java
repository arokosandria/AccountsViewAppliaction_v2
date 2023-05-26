package pl.coderslab.accountsview.currency;

import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.TestPropertySource;

import pl.coderslab.accountsview.currencycheduled.CurrencyScheduled;


import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;


@SpringBootTest
@TestPropertySource(properties = "task.work.rate=100")
public class ScheduledTest {

    @SpyBean
    private CurrencyScheduled currencyScheduled;

    @Test
    public void jobRuns() {
        Awaitility.await().atMost(30, TimeUnit.SECONDS).untilAsserted(() ->
                verify(currencyScheduled, Mockito.atLeastOnce()).every30SecondsReadCurrency());
    }
}