package pl.coderslab.accountsview.address;

import javax.validation.constraints.NotBlank;

public record AddressDto(Long id,
                         @NotBlank(message = "numer nie pusty")
                         String street,

                         Integer number,
                         Integer numberFlat,
                         String postCode,
                         String city) {
}
