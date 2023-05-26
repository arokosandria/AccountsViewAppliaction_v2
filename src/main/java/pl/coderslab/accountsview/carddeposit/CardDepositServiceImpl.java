package pl.coderslab.accountsview.carddeposit;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.accountsview.accountdeposit.AccountDeposit;
import pl.coderslab.accountsview.accountdeposit.AccountDepositRepository;
import pl.coderslab.accountsview.person.Person;
import pl.coderslab.accountsview.person.PersonRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CardDepositServiceImpl implements CardDepositService {

    private final PersonRepository personRepository;
    private final CardDepositRepository cardDepositRepository;
    private final AccountDepositRepository accountDepositRepository;


    @Override
    @Transactional
    public CardDepositDto create(CardDepositDto cardDepositDto) {
        Person person =
                personRepository
                        .findByName(cardDepositDto.getPersonName()).orElseThrow();

        AccountDeposit accountDeposit =
                accountDepositRepository
                        .findByNumberAccountAndPerson(cardDepositDto.getNumberAccount(), person)
                        .orElseThrow(() ->
                                new IllegalArgumentException("No account number "
                                        + cardDepositDto.getNumberAccount() + " for person "
                                        + cardDepositDto.getPersonName()));


        CardDeposit cardDeposit =
                CardDeposit.builder()
                        .person(person)
                        .accountDeposit(accountDeposit)
                        .name(cardDepositDto.getName())
                        .numberCard(cardDepositDto.getNumberCard())
                        .build();
        cardDepositRepository.save(cardDeposit);


        return toDto(cardDeposit);
    }


    @Override
    public List<CardDepositDto> getAll() {

        return cardDepositRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }



    @Override
    public Optional<CardDepositDto> getByNumberCard(String cardNumber) {
        Optional<CardDeposit> cardDeposit = cardDepositRepository.findByNumberCard(cardNumber);
        return cardDeposit.map(this::toDto);
    }

    @Override
    public  List<CardDepositDto> getByNumberAccount(String numberAccount) {
        List<CardDeposit> cardDeposit = cardDepositRepository.getCardDepositsByAccountDeposit_NumberAccount(numberAccount);
        return cardDeposit.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public CardDepositDto update(UpdateCardDepositRequest request) {
        return cardDepositRepository
                .findByNumberCard(request.numberCard())
                .map(
                        cardDeposit -> {

                            if (request.name() != null) {
                                cardDeposit.setName(request.name());
                            }

                            return cardDeposit;
                        })
                .map(cardDepositRepository::save)
                .map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("No card with CardNumber " + request.numberCard()));
    }

    @Override
    public void delete(Long id) {
        cardDepositRepository.deleteById(id);
    }




    private CardDepositDto toDto(CardDeposit cardDeposit) {
        return new CardDepositDto(
                cardDeposit.getPerson().getName(),
                cardDeposit.getAccountDeposit().getNumberAccount(),
                cardDeposit.getName(),
                cardDeposit.getNumberCard()

        );

    }
}

