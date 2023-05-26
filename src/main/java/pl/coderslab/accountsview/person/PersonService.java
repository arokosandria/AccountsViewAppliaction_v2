package pl.coderslab.accountsview.person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    List<PersonDto> getAll();

    PersonDto getByName(String name);

    PersonDto getById(Long id);

    PersonDto create(PersonDto personDto);

    PersonDto update(UpdatePersonRequest request);

    void delete(Long id);
}
