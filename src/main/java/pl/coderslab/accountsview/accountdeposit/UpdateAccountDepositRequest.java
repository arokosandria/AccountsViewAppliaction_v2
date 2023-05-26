package pl.coderslab.accountsview.accountdeposit;

import javax.validation.constraints.NotBlank;

public record UpdateAccountDepositRequest(
        @NotBlank String numberAccount,
        Double balance,
        String nameAccount) {
}
