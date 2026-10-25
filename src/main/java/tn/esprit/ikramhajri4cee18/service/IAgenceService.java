package tn.esprit.ikramhajri4cee18.service;
import java.util.List;
import java.util.Optional;
import tn.esprit.ikramhajri4cee18.domain.Agence;

public interface IAgenceService {

    Agence enregistrer(Agence agence);

    List<Agence> lister();

    Optional<Agence> chercherParId(Long id);

    void supprimerParId(Long id);
}
