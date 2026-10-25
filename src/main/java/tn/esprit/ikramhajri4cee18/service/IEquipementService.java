package tn.esprit.ikramhajri4cee18.service;

import java.util.List;
import java.util.Optional;
import tn.esprit.ikramhajri4cee18.domain.Equipement;

public interface IEquipementService {

    Equipement enregistrer(Equipement equipement);

    List<Equipement> lister();

    Optional<Equipement> chercherParId(Long id);

    void supprimerParId(Long id);
}
