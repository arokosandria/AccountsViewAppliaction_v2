package pl.coderslab.accountsview.accountdeposit;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.accountsview.carddeposit.CardDepositDto;
import pl.coderslab.accountsview.carddeposit.UpdateCardDepositRequest;
import pl.coderslab.accountsview.exception.ResourceNotFoundException;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/account")
@Slf4j
@RequiredArgsConstructor
public class AccountDepositController {
    private final AccountDepositService accountDepositService;

    @PostMapping
    public ResponseEntity<AccountDepositDto> create(@RequestBody @Valid AccountDepositDto accountDepositDto) {
        AccountDepositDto accountDepositDto1 = accountDepositService.create(accountDepositDto);
        return ResponseEntity.ok(accountDepositDto1);
    }

    @PutMapping("/{accountNumber}")
    public ResponseEntity<AccountDepositDto> updateAccountDeposit(
            @PathVariable String accountNumber, @RequestBody @Valid UpdateAccountDepositRequest request) {
        if (!accountNumber.equals(request.numberAccount())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "NumberAccount mismatch");
        }
        AccountDepositDto cardDepositDto = accountDepositService.update(request);
        return ResponseEntity.ok(cardDepositDto);
    }

    @GetMapping
    public List<AccountDepositDto> getAllAccount() {
        List<AccountDepositDto> accountDepositDtoAll = accountDepositService.getAll();
        return accountDepositDtoAll;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        try {
            accountDepositService.delete(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new ResourceNotFoundException("Account not found");
        }
    }
}
