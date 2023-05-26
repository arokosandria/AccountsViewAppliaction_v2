package pl.coderslab.accountsview.accountdeposit;

import lombok.*;
import pl.coderslab.accountsview.carddeposit.CardDeposit;
import pl.coderslab.accountsview.person.Person;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accountdeposits")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDeposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String numberAccount;
    private double balance;
    private String nameAccount;
    @ManyToOne(optional = false)
    private Person person;
    @OneToMany(mappedBy = "accountDeposit")
    @ToString.Exclude
    private List<CardDeposit> cardDepositList=new ArrayList<>();

}
