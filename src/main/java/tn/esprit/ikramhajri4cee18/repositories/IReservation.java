
package tn.esprit.ikramhajri4cee18.repositories;

import tn.esprit.ikramhajri4cee18.domain.Reservation;
import tn.esprit.ikramhajri4cee18.domain.StatutReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.time.LocalDate;

public interface IReservation
        extends JpaRepository<Reservation, Long> {

    List<Reservation> findByStatut(StatutReservation statut);

    List<Reservation> findByClient_IdClient(Long idClient);

    List<Reservation> findByVehicule_IdVehicule(Long idVehicule);

    List<Reservation> findByDateDebut(LocalDate dateDebut);

    List<Reservation> findByDateDebutBetween(
            LocalDate debut, LocalDate fin);

    List<Reservation> findByClient_IdClientAndStatut(
            Long idClient, StatutReservation statut);
}
