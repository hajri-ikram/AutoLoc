package tn.esprit.ikramhajri4cee18.service;
import java.util.List;
import java.util.Optional;
import tn.esprit.ikramhajri4cee18.domain.Employe;

public interface IEmployeService {

    Employe enregistrer(Employe employe);

    List<Employe> lister();

    Optional<Employe> chercherParId(Long id);

    void supprimerParId(Long id);
}
