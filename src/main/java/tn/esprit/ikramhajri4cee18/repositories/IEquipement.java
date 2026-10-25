

package tn.esprit.ikramhajri4cee18.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ikramhajri4cee18.domain.Equipement;

public interface IEquipement
        extends JpaRepository<Equipement, Long> {
}
