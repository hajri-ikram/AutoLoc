package tn.esprit.ikramhajri4cee18.service;
import java.util.List;
import java.util.Optional;
import tn.esprit.ikramhajri4cee18.domain.contrat;

public interface IContratService {

    contrat enregistrer(contrat contrat);

    List<contrat> lister();

    Optional<contrat> chercherParId(Long id);

    void supprimerParId(Long id);
}
