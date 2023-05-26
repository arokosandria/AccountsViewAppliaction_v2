package pl.coderslab.accountsview.accountdeposit;
import java.util.List;

public interface AccountDepositService {
    AccountDepositDto create(AccountDepositDto accountDepositDto);

    List<AccountDepositDto> getAll();

    void delete(Long id);

    AccountDepositDto update(UpdateAccountDepositRequest request);
}
