package pl.coderslab.accountsview.person;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import pl.coderslab.accountsview.address.Address;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class PersonServiceImplTest {
    @Mock
    PersonMapper personMapper;
    @Mock
    PersonRepository personRepository;
    @InjectMocks
    PersonServiceImpl personService;


    @Test
    public void givenPerson_whenFindById_thenFindPerson() {
        Address address = new Address(1L, "Czachowskiego", 12, 3, "27-900", "krakow");
        Person person = new Person(1L, "konto_numer1", "karolina.mrowka@interia.pl", LocalDate.parse("2014-03-18"), "karolina", "mrowka", "73120639665", address);
        PersonDto personDto = new PersonDto(1L, "konto_numer1", "karolina.mrowka@interia.pl", LocalDate.parse("2014-03-18"), "karolina", "mrowka", "73120639665", address);
        when(personRepository.findById(1L)).thenReturn(Optional.of(person));
        when(personMapper.toDto(person)).thenReturn(personDto);
        PersonDto actual = personService.getById(1L);
        assertEquals(personDto,actual);
    }

    @Test
    public void givenPerson_whenFindName_thenFindPerson() {
        Address address = new Address(1L, "Czachowskiego", 12, 3, "27-900", "krakow");
        Person person = new Person(1L, "konto_numer1", "karolina.mrowka@interia.pl", LocalDate.parse("2014-03-18"), "karolina", "mrowka", "73120639665", address);
        PersonDto personDto = new PersonDto(1L, "konto_numer1", "karolina.mrowka@interia.pl", LocalDate.parse("2014-03-18"), "karolina", "mrowka", "73120639665", address);
        when(personRepository.findByName("konto_numer1")).thenReturn(Optional.of(person));
        when(personMapper.toDto(person)).thenReturn(personDto);
        PersonDto actual = personService.getByName("konto_numer1");
        assertEquals(personDto.getName(),actual.getName());
    }

    @Test
    public void when_save_person_then_it_is_returned_correctly() {

        Address address = new Address(1L, "Czachowskiego", 12, 3, "27-900", "krakow");
        Person person = new Person(1L, "konto_numer1", "karolina.mrowka@interia.pl", LocalDate.parse("2014-03-18"), "karolina", "mrowka", "73120639665", address);
        PersonDto personDto = new PersonDto(1L, "konto_numer1", "karolina.mrowka@interia.pl", LocalDate.parse("2014-03-18"), "karolina", "mrowka", "73120639665", address);
        when(personRepository.save(personMapper.dtoTo(personDto))).thenReturn(person);
        when(personMapper.toDto(person)).thenReturn(personDto);
        PersonDto actual = personService.create(personDto);
        assertEquals(personDto.getFirstName(),actual.getFirstName());
    }
}