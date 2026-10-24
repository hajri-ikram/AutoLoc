
package tn.esprit.ikramhajri4cee18.service;

import org.springframework.stereotype.Service;
import tn.esprit.ikramhajri4cee18.domain.Vehicule;
import tn.esprit.ikramhajri4cee18.domain.StatutVehicule;
import tn.esprit.ikramhajri4cee18.domain.CategorieVehicule;
import tn.esprit.ikramhajri4cee18.repositories.IVehiculeRepository;
import java.util.List;

@Service
public class VehiculeService {

    private final IVehiculeRepository vehiculeRepository;

    public VehiculeService(IVehiculeRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }
    public Vehicule ajouter(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }
    public List<Vehicule> afficherTous() {
        return vehiculeRepository.findAll();
    }
    public Vehicule chercherParId(Long id) {
        return vehiculeRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Véhicule introuvable"));
    }
    public Vehicule modifier(Long id, Vehicule nouveauVehicule) {
        Vehicule vehicule = chercherParId(id);

        vehicule.setImmatriculation(nouveauVehicule.getImmatriculation());
        vehicule.setMarque(nouveauVehicule.getMarque());
        vehicule.setModele(nouveauVehicule.getModele());
        vehicule.setCategorie(nouveauVehicule.getCategorie());
        vehicule.setTarifJournalier(nouveauVehicule.getTarifJournalier());
        vehicule.setStatut(nouveauVehicule.getStatut());
        vehicule.setAgence(nouveauVehicule.getAgence());

        return vehiculeRepository.save(vehicule);
    }
    public void supprimer(Long id) {
        Vehicule vehicule = chercherParId(id);
        vehiculeRepository.delete(vehicule);
    }
    public List<Vehicule> rechercherParStatut(StatutVehicule statut) {
        return vehiculeRepository.findByStatut(statut);
    }
    public List<Vehicule> rechercherParAgence(Long idAgence) {
        return vehiculeRepository.findByAgence_IdAgence(idAgence);
    }
    public List<Vehicule> rechercherParMarque(String marque) {
        return vehiculeRepository.findByMarque(marque);
    }
    public List<Vehicule> rechercherParCategorie(CategorieVehicule categorie) {
        return vehiculeRepository.findByCategorie(categorie);
    }
    public boolean immatriculationExiste(String immatriculation) {
        return vehiculeRepository.existsByImmatriculation(immatriculation);
    }
}
