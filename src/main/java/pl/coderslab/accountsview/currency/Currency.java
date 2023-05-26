package pl.coderslab.accountsview.currency;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "currency")
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String currency;
    private double mid;


}
