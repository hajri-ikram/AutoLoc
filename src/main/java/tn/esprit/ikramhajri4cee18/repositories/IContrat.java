
package tn.esprit.ikramhajri4cee18.repositories;

import tn.esprit.ikramhajri4cee18.domain.contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.time.LocalDate;
import java.math.BigDecimal;

public interface IContrat extends JpaRepository<contrat, Long> {

    List<contrat> findByValide(boolean valide);

    List<contrat> findByDateSignature(LocalDate dateSignature);

    List<contrat> findByMontantTotalGreaterThan(BigDecimal montant);

    List<contrat> findByReservation_IdReservation(Long idReservation);
}
