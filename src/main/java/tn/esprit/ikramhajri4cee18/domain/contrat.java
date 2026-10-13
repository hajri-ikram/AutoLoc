package tn.esprit.ikramhajri4cee18.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "contrat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;
    private LocalDate dateSignature;
    private BigDecimal montantTotal;
    private boolean valide;
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    Set<Paiement> paiement;
    @OneToOne
    @JoinColumn(name = "reservation_id", unique = true)
    private Reservation reservation;
}
