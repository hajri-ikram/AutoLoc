
package tn.esprit.ikramhajri4cee18.service;

import java.util.List;
import java.util.Optional;
import tn.esprit.ikramhajri4cee18.domain.Paiement;

public interface IPaiementService {

    Paiement enregistrer(Paiement paiement);

    List<Paiement> lister();

    Optional<Paiement> chercherParId(Long id);

    void supprimerParId(Long id);
}
