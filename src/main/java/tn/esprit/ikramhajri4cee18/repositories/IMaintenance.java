
package tn.esprit.ikramhajri4cee18.repositories;

import tn.esprit.ikramhajri4cee18.domain.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.time.LocalDate;

public interface IMaintenance extends JpaRepository<Maintenance, Long> {

    List<Maintenance> findByVehicule_IdVehicule(Long idVehicule);

    List<Maintenance> findByDateDebut(LocalDate dateDebut);

    List<Maintenance> findByDateFin(LocalDate dateFin);

    List<Maintenance> findByDateDebutBetween(
            LocalDate debut, LocalDate fin);

    List<Maintenance> findByDescriptionContainingIgnoreCase(
            String description);
}

