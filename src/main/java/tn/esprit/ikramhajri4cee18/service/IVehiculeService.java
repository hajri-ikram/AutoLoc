package tn.esprit.ikramhajri4cee18.service;
import tn.esprit.ikramhajri4cee18.domain.Vehicule;
import java.util.List;
import java.util.Optional;

public interface IVehiculeService {

    Vehicule enregistrer(Vehicule vehicule);

    List<Vehicule> lister();

    Optional<Vehicule> chercherParId(Long id);

    void supprimerParId(Long id);
}



