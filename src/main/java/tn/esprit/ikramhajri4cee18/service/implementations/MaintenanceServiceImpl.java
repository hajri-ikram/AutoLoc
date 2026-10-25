
package tn.esprit.ikramhajri4cee18.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.ikramhajri4cee18.domain.Maintenance;
import tn.esprit.ikramhajri4cee18.repositories.IMaintenance;
import tn.esprit.ikramhajri4cee18.service.IMaintenanceService;

@Service
@Transactional(readOnly = true)
public class MaintenanceServiceImpl implements IMaintenanceService {

    private final IMaintenance repository;

    public MaintenanceServiceImpl(IMaintenance repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Maintenance enregistrer(Maintenance maintenance) {
        return repository.save(maintenance);
    }

    @Override
    public List<Maintenance> lister() {
        return repository.findAll();
    }

    @Override
    public Optional<Maintenance> chercherParId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public void supprimerParId(Long id) {
        repository.deleteById(id);
    }
}
