package pl.coderslab.accountsview.accountdeposit;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.accountsview.carddeposit.CardDeposit;
import pl.coderslab.accountsview.person.Person;


import java.util.List;
import java.util.Optional;

public interface AccountDepositRepository extends JpaRepository<AccountDeposit, Long> {
    Optional<AccountDeposit> findByNumberAccount(String numberAccount);
    Optional<AccountDeposit> findByNumberAccountAndPerson(String numberAccount, Person person);

}
