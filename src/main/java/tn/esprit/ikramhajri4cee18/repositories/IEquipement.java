
package tn.esprit.ikramhajri4cee18.repositories;

import tn.esprit.ikramhajri4cee18.domain.Equipement;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IEquipement extends JpaRepository<Equipement, Long> {

    List<Equipement> findByLibelle(String libelle);

    List<Equipement> findByLibelleContainingIgnoreCase(String libelle);

    List<Equipement> findByVehicules_IdVehicule(Long idVehicule);
}
