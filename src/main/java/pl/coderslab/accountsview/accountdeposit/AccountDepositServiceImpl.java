package pl.coderslab.accountsview.accountdeposit;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.coderslab.accountsview.person.Person;
import pl.coderslab.accountsview.person.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
@RequiredArgsConstructor
public class AccountDepositServiceImpl implements AccountDepositService {

    private final PersonRepository personRepository;
    private final AccountDepositRepository accountDepositRepository;
    private final AccountDepositMapper accountDepositMapper;

    @Override
    @Transactional
    public AccountDepositDto create(AccountDepositDto accountDepositDto) {

        Person persons = personRepository.findByName(accountDepositDto.getName()).orElseThrow(() -> new IllegalArgumentException("No person with name " +accountDepositDto.getName()));
        AccountDeposit accountDeposit =
                AccountDeposit.builder()
                        .person(persons)
                        .nameAccount(accountDepositDto.getNameAccount())
                        .balance(accountDepositDto.getBalance())
                        .numberAccount(accountDepositDto.getNumberAccount())
                        .build();
        accountDepositRepository.save(accountDeposit);
        return accountDepositMapper.toDto(accountDeposit);
    }

    @Override
    public List<AccountDepositDto> getAll() {
        return accountDepositRepository.findAll().stream()
                .map(accountDepositMapper::toDto)
                .collect(Collectors.toList());
    }


    public AccountDepositDto update(UpdateAccountDepositRequest request) {
        return accountDepositRepository
                .findByNumberAccount(request.numberAccount())
                .map(
                        accountDeposit -> {

                            if (request.nameAccount() != null) {
                                accountDeposit.setNameAccount(request.nameAccount());
                            };
                            if (request.balance()!=null){
                                accountDeposit.setBalance(request.balance());
                            }

                            return accountDeposit;
                        })
                .map(accountDepositRepository::save)
                .map(accountDepositMapper::toDto)
                .orElseThrow(() -> new IllegalArgumentException("No account Number with this numerAccount " + request.numberAccount()));
    }
    @Override
    public void delete(Long id) {
        accountDepositRepository.deleteById(id);
    }
}
