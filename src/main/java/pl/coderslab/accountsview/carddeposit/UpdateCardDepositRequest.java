package pl.coderslab.accountsview.carddeposit;

import javax.validation.constraints.NotBlank;

public record UpdateCardDepositRequest(@NotBlank String numberCard,
                                       @NotBlank String personName,
                                       String name)
{
                    }
