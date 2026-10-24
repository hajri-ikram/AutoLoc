
package tn.esprit.ikramhajri4cee18.service;

import org.springframework.stereotype.Service;
import tn.esprit.ikramhajri4cee18.domain.Employe;
import tn.esprit.ikramhajri4cee18.domain.RoleEmploye;
import tn.esprit.ikramhajri4cee18.repositories.IEmploye;
import java.util.List;

@Service
public class EmployeService {

    private final IEmploye employeRepository;

    public EmployeService(IEmploye employeRepository) {
        this.employeRepository = employeRepository;
    }

    public Employe ajouter(Employe employe) {
        return employeRepository.save(employe);
    }

    public List<Employe> afficherTous() {
        return employeRepository.findAll();
    }

    public Employe chercherParId(Long id) {
        return employeRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Employé introuvable"));
    }

    public Employe modifier(Long id, Employe nouvelEmploye) {
        Employe employe = chercherParId(id);

        employe.setNom(nouvelEmploye.getNom());
        employe.setPrenom(nouvelEmploye.getPrenom());
        employe.setRole(nouvelEmploye.getRole());
        employe.setAgence(nouvelEmploye.getAgence());

        return employeRepository.save(employe);
    }

    public void supprimer(Long id) {
        Employe employe = chercherParId(id);
        employeRepository.delete(employe);
    }

    public List<Employe> rechercherParNom(String nom) {
        return employeRepository.findByNomContainingIgnoreCase(nom);
    }

    public List<Employe> rechercherParRole(RoleEmploye role) {
        return employeRepository.findByRole(role);
    }

    public List<Employe> rechercherParAgence(Long idAgence) {
        return employeRepository.findByAgence_IdAgence(idAgence);
    }
}
