package tn.esprit.ikramhajri4cee18.service;
import org.springframework.stereotype.Service;
import tn.esprit.ikramhajri4cee18.domain.Equipement;
import tn.esprit.ikramhajri4cee18.repositories.IEquipement;
import java.util.List;

@Service
public class EquipementService {

    private final IEquipement equipementRepository;

    public EquipementService(IEquipement equipementRepository) {
        this.equipementRepository = equipementRepository;
    }

    public Equipement ajouter(Equipement equipement) {
        return equipementRepository.save(equipement);
    }
    public List<Equipement> afficherTous() {
        return equipementRepository.findAll();
    }
    public Equipement chercherParId(Long id) {
        return equipementRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Équipement introuvable"));
    }
    public Equipement modifier(Long id, Equipement nouvelEquipement) {
        Equipement equipement = chercherParId(id);

        equipement.setLibelle(nouvelEquipement.getLibelle());

        return equipementRepository.save(equipement);
    }
    public void supprimer(Long id) {
        Equipement equipement = chercherParId(id);
        equipementRepository.delete(equipement);
    }
    public List<Equipement> rechercherParLibelle(String libelle) {
        return equipementRepository.findByLibelleContainingIgnoreCase(libelle);
    }
    public List<Equipement> rechercherParVehicule(Long idVehicule) {
        return equipementRepository.findByVehicules_IdVehicule(idVehicule);
    }
}
