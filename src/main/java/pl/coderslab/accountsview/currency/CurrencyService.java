package pl.coderslab.accountsview.currency;

import pl.coderslab.accountsview.carddeposit.CardDepositDto;

public interface CurrencyService {
    CurrencyResponse getByNumberAccount(String numberAccount, String currency);
    void delete();
}
