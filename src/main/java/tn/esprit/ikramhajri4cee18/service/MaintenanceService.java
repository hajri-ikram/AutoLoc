package tn.esprit.ikramhajri4cee18.service;

import org.springframework.stereotype.Service;
import tn.esprit.ikramhajri4cee18.domain.Maintenance;
import tn.esprit.ikramhajri4cee18.repositories.IMaintenance;
import java.util.List;
import java.time.LocalDate;

@Service
public class MaintenanceService {

    private final IMaintenance maintenanceRepository;

    public MaintenanceService(IMaintenance maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }
    public Maintenance ajouter(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }
    public List<Maintenance> afficherTous() {
        return maintenanceRepository.findAll();
    }
    public Maintenance chercherParId(Long id) {
        return maintenanceRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Maintenance introuvable"));
    }
    public Maintenance modifier(Long id, Maintenance nouvelleMaintenance) {
        Maintenance maintenance = chercherParId(id);

        maintenance.setDateDebut(nouvelleMaintenance.getDateDebut());
        maintenance.setDateFin(nouvelleMaintenance.getDateFin());
        maintenance.setDescription(nouvelleMaintenance.getDescription());
        maintenance.setVehicule(nouvelleMaintenance.getVehicule());

        return maintenanceRepository.save(maintenance);
    }
    public void supprimer(Long id) {
        Maintenance maintenance = chercherParId(id);
        maintenanceRepository.delete(maintenance);
    }
    public List<Maintenance> rechercherParVehicule(Long idVehicule) {
        return maintenanceRepository.findByVehicule_IdVehicule(idVehicule);
    }
    public List<Maintenance> rechercherParPeriode(
            LocalDate debut, LocalDate fin) {
        return maintenanceRepository.findByDateDebutBetween(debut, fin);
    }
    public List<Maintenance> rechercherParDescription(String description) {
        return maintenanceRepository
                .findByDescriptionContainingIgnoreCase(description);
    }
}
