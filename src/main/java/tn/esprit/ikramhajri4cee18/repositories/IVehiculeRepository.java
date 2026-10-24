
package tn.esprit.ikramhajri4cee18.repositories;

import tn.esprit.ikramhajri4cee18.domain.Vehicule;
import tn.esprit.ikramhajri4cee18.domain.StatutVehicule;
import tn.esprit.ikramhajri4cee18.domain.CategorieVehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IVehiculeRepository
        extends JpaRepository<Vehicule, Long> {

    List<Vehicule> findByStatut(StatutVehicule statut);

    List<Vehicule> findByAgence_IdAgence(Long idAgence);

    boolean existsByImmatriculation(String immatriculation);

    List<Vehicule> findByMarque(String marque);

    List<Vehicule> findByCategorie(CategorieVehicule categorie);

    List<Vehicule> findByMarqueAndModele(String marque, String modele);
}
