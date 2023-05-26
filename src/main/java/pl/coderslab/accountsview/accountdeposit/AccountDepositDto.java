package pl.coderslab.accountsview.accountdeposit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pl.coderslab.accountsview.person.Person;

import javax.persistence.PrePersist;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Getter
@AllArgsConstructor
public class AccountDepositDto {
    @NotBlank(message = "nie prawidlowy numer konta")
    @Pattern(regexp = "^(\\d{26})$")
    private String numberAccount;
    private double balance;
    @NotBlank(message = "nameAccount nie moze byc puste")
    private String nameAccount;
    @NotBlank(message = "name nie moze byc puste")
    @JsonInclude(JsonInclude.Include.NON_NULL)

    private String name;
}
