package pl.coderslab.accountsview.carddeposit;

import lombok.*;
import pl.coderslab.accountsview.accountdeposit.AccountDeposit;
import pl.coderslab.accountsview.person.Person;

import javax.persistence.*;

@Entity
@Table(name = "carddeposits")

@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class CardDeposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 16, name = "cardnumber")
    private String numberCard;
    private String name;
    @ManyToOne(optional = false)
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;
    @ManyToOne(optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    private AccountDeposit accountDeposit;


}
