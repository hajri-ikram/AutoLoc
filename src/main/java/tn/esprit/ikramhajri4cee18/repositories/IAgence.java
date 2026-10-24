
package tn.esprit.ikramhajri4cee18.repositories;

import tn.esprit.ikramhajri4cee18.domain.Agence;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IAgence extends JpaRepository<Agence, Long> {

    List<Agence> findByVille(String ville);

    List<Agence> findByNom(String nom);

    List<Agence> findByVilleIgnoreCase(String ville);

    List<Agence> findByNomContainingIgnoreCase(String nom);
}
