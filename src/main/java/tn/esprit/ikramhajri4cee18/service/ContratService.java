
package tn.esprit.ikramhajri4cee18.service;

import org.springframework.stereotype.Service;
import tn.esprit.ikramhajri4cee18.domain.contrat;
import tn.esprit.ikramhajri4cee18.repositories.IContrat;
import java.util.List;
import java.math.BigDecimal;

@Service
public class ContratService {

    private final IContrat contratRepository;

    public ContratService(IContrat contratRepository) {
        this.contratRepository = contratRepository;
    }
    public contrat ajouter(contrat contrat) {
        return contratRepository.save(contrat);
    }
    public List<contrat> afficherTous() {
        return contratRepository.findAll();
    }
    public contrat chercherParId(Long id) {
        return contratRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Contrat introuvable"));
    }

    public contrat modifier(Long id, contrat nouveauContrat) {
        contrat contrat = chercherParId(id);

        contrat.setDateSignature(nouveauContrat.getDateSignature());
        contrat.setMontantTotal(nouveauContrat.getMontantTotal());
        contrat.setValide(nouveauContrat.isValide());

        return contratRepository.save(contrat);
    }

    public void supprimer(Long id) {
        contrat contrat = chercherParId(id);
        contratRepository.delete(contrat);
    }
    public List<contrat> rechercherParValidite(boolean valide) {
        return contratRepository.findByValide(valide);
    }

    public List<contrat> rechercherParMontant(BigDecimal montant) {
        return contratRepository.findByMontantTotalGreaterThan(montant);
    }

    public List<contrat> rechercherParReservation(Long idReservation) {
        return contratRepository.findByReservation_IdReservation(idReservation);
    }
}
