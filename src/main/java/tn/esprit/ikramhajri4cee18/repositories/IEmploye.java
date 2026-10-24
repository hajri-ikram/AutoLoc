
package tn.esprit.ikramhajri4cee18.repositories;

import tn.esprit.ikramhajri4cee18.domain.Employe;
import tn.esprit.ikramhajri4cee18.domain.RoleEmploye;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IEmploye extends JpaRepository<Employe, Long> {

    List<Employe> findByNom(String nom);

    List<Employe> findByPrenom(String prenom);

    List<Employe> findByRole(RoleEmploye role);

    List<Employe> findByAgence_IdAgence(Long idAgence);

    List<Employe> findByNomContainingIgnoreCase(String nom);
}
