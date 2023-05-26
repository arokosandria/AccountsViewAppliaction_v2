package pl.coderslab.accountsview.person;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.jdbc.Sql;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Sql
class PersonRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    PersonRepository repository;

    @Test
    public void find_by_name_then_return_person() {

        Person person = entityManager.find(Person.class, 1L);
        //when
        Optional<Person> result = repository.findByName("konto_numer_1");
        //then
        assertEquals(person.getName(), result.get().getName());
    }
    @Test
    public void find_by_id_then_return_person() {

        Person person = entityManager.find(Person.class, 1L);
        //when
        Optional<Person> result = repository.findById(1L);
        //then
        assertEquals(person.getId(), result.get().getId());
    }


}

