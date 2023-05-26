package pl.coderslab.accountsview.person;
import lombok.*;
import pl.coderslab.accountsview.address.Address;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "persons")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    private String email;
    @Column(nullable = false)
    private LocalDate birthday;
    private String firstName;
    private String lastName;
    @Column(nullable = false, unique = true)
    private String pesel;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDRESS_ID", nullable = false)
    private Address address;


}