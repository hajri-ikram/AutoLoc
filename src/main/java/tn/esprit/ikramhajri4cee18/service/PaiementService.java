package tn.esprit.ikramhajri4cee18.service;
import org.springframework.stereotype.Service;
import tn.esprit.ikramhajri4cee18.domain.Paiement;
import tn.esprit.ikramhajri4cee18.domain.ModePaiement;
import tn.esprit.ikramhajri4cee18.repositories.IPaiement;
import java.util.List;
import java.time.LocalDate;
import java.math.BigDecimal;

@Service
public class PaiementService {

    private final IPaiement paiementRepository;

    public PaiementService(IPaiement paiementRepository) {
        this.paiementRepository = paiementRepository;
    }
    public Paiement ajouter(Paiement paiement) {
        return paiementRepository.save(paiement);
    }
    public List<Paiement> afficherTous() {
        return paiementRepository.findAll();
    }
    public Paiement chercherParId(Long id) {
        return paiementRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Paiement introuvable"));
    }
    public Paiement modifier(Long id, Paiement nouveauPaiement) {
        Paiement paiement = chercherParId(id);

        paiement.setMontant(nouveauPaiement.getMontant());
        paiement.setDatePaiement(nouveauPaiement.getDatePaiement());
        paiement.setModePaiement(nouveauPaiement.getModePaiement());
        paiement.setContrat(nouveauPaiement.getContrat());

        return paiementRepository.save(paiement);
    }
    public void supprimer(Long id) {
        Paiement paiement = chercherParId(id);
        paiementRepository.delete(paiement);
    }
    public List<Paiement> rechercherParMode(ModePaiement mode) {
        return paiementRepository.findByModePaiement(mode);
    }
    public List<Paiement> rechercherParContrat(Long idContrat) {
        return paiementRepository.findByContrat_IdContrat(idContrat);
    }
    public List<Paiement> rechercherParPeriode(
            LocalDate debut, LocalDate fin) {
        return paiementRepository.findByDatePaiementBetween(debut, fin);
    }
    public List<Paiement> rechercherParMontant(BigDecimal montant) {
        return paiementRepository.findByMontantGreaterThan(montant);
    }
}
