package pl.coderslab.accountsview.person;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person,Long> {
    Optional<Person> findByName(String name);
    Optional<Person> findById(Long id);
}
