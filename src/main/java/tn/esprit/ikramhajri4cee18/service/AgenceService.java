package tn.esprit.ikramhajri4cee18.service;
import org.springframework.stereotype.Service;
import tn.esprit.ikramhajri4cee18.domain.Agence;
import tn.esprit.ikramhajri4cee18.repositories.IAgence;
import java.util.List;
@Service
public class AgenceService {
    private final IAgence agenceRepository;
    public AgenceService(IAgence agenceRepository) {
        this.agenceRepository = agenceRepository;
    }
    public Agence ajouter(Agence agence) {
        return agenceRepository.save(agence);
    }
    public List<Agence> afficherTous() {
        return agenceRepository.findAll();
    }
    public Agence chercherParId(Long id) {
        return agenceRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Agence introuvable"));
    }
    public Agence modifier(Long id, Agence nouvelleAgence) {
        Agence agence = chercherParId(id);

        agence.setNom(nouvelleAgence.getNom());
        agence.setVille(nouvelleAgence.getVille());
        agence.setAdresse(nouvelleAgence.getAdresse());
        agence.setTelephone(nouvelleAgence.getTelephone());

        return agenceRepository.save(agence);
    }
    public void supprimer(Long id) {
        Agence agence = chercherParId(id);
        agenceRepository.delete(agence);
    }
    public List<Agence> rechercherParVille(String ville) {
        return agenceRepository.findByVilleIgnoreCase(ville);
    }
    public List<Agence> rechercherParNom(String nom) {
        return agenceRepository.findByNomContainingIgnoreCase(nom);
    }
}
