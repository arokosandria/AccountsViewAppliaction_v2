package pl.coderslab.accountsview.person;

import javax.validation.constraints.NotBlank;

public record UpdatePersonRequest(@NotBlank(message = "parametr name jest wymagany")
                                  String name,
                                  String lastName,
                                  String email) {
}
