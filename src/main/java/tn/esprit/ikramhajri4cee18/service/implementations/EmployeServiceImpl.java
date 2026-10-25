package tn.esprit.ikramhajri4cee18.service.implementations;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.ikramhajri4cee18.domain.Employe;
import tn.esprit.ikramhajri4cee18.repositories.IEmploye;
import tn.esprit.ikramhajri4cee18.service.IEmployeService;

@Service
@Transactional(readOnly = true)
public class EmployeServiceImpl implements IEmployeService {

    private final IEmploye repository;

    public EmployeServiceImpl(IEmploye repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Employe enregistrer(Employe employe) {
        return repository.save(employe);
    }

    @Override
    public List<Employe> lister() {
        return repository.findAll();
    }

    @Override
    public Optional<Employe> chercherParId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public void supprimerParId(Long id) {
        repository.deleteById(id);
    }
}