
package tn.esprit.ikramhajri4cee18.service;

import java.util.List;
import java.util.Optional;
import tn.esprit.ikramhajri4cee18.domain.Maintenance;

public interface IMaintenanceService {

    Maintenance enregistrer(Maintenance maintenance);

    List<Maintenance> lister();

    Optional<Maintenance> chercherParId(Long id);

    void supprimerParId(Long id);
}
