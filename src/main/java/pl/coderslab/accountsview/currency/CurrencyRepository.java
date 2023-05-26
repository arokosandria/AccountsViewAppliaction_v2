package pl.coderslab.accountsview.currency;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    Currency findMidByCurrency(String currency);

    void deleteAll();
}
