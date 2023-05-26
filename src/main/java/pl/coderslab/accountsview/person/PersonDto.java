package pl.coderslab.accountsview.person;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.pl.PESEL;
import pl.coderslab.accountsview.address.Address;
import javax.validation.constraints.*;
import java.time.LocalDate;


@Data
@Getter
@AllArgsConstructor
public class PersonDto {
  private Long id;
    @NotBlank(message = "parametr name jest wymagany")
    private String name;
    @Email
    private String email;
    @NotNull @Past
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate birthday;
    @NotBlank(message = "parametr firstName jest wymagany")
    private String firstName;
    @NotBlank(message = "parametr lastName jest wymagany")
    private String lastName;
    @PESEL@NotNull
    private String pesel;
    private Address address;
}
