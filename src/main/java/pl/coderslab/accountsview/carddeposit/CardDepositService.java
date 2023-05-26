package pl.coderslab.accountsview.carddeposit;



import java.util.List;
import java.util.Optional;

public interface CardDepositService {

    CardDepositDto create(CardDepositDto cardDepositDto);
    List<CardDepositDto> getAll();
    Optional<CardDepositDto> getByNumberCard(String cardNumber);

   List<CardDepositDto> getByNumberAccount(String numberAccount);

    CardDepositDto update(UpdateCardDepositRequest request);
    void delete(Long id);

}
