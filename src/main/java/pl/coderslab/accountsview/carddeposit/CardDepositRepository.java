package pl.coderslab.accountsview.carddeposit;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface CardDepositRepository extends JpaRepository<CardDeposit, Long> {
    Optional<CardDeposit> findByNumberCard(String numberCard);
    List<CardDeposit> getCardDepositsByAccountDeposit_NumberAccount(String numberAccount);
}
