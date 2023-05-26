package pl.coderslab.accountsview.carddeposit;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CardDepositDto {
    @NotBlank(message = "personName jest wymagane")
    private String personName;
    @NotBlank(message = "numberAccount jest wymagane")
    private String numberAccount;
    @NotBlank(message = "name jest wymagane")
    private String name;
    @NotBlank(message = "numberCard jest wymagane")
    private String numberCard;

}
