
package tn.esprit.ikramhajri4cee18.repositories;

import tn.esprit.ikramhajri4cee18.domain.Paiement;
import tn.esprit.ikramhajri4cee18.domain.ModePaiement;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.time.LocalDate;
import java.math.BigDecimal;

public interface IPaiement extends JpaRepository<Paiement, Long> {

    List<Paiement> findByModePaiement(ModePaiement modePaiement);

    List<Paiement> findByContrat_IdContrat(Long idContrat);

    List<Paiement> findByDatePaiement(LocalDate datePaiement);

    List<Paiement> findByMontantGreaterThan(BigDecimal montant);

    List<Paiement> findByDatePaiementBetween(
            LocalDate debut, LocalDate fin);
}
