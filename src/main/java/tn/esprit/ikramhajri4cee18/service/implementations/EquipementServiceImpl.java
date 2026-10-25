package tn.esprit.ikramhajri4cee18.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.ikramhajri4cee18.domain.Equipement;
import tn.esprit.ikramhajri4cee18.repositories.IEquipement;
import tn.esprit.ikramhajri4cee18.service.IEquipementService;

@Service
@Transactional(readOnly = true)
public class EquipementServiceImpl implements IEquipementService {

    private final IEquipement repository;

    public EquipementServiceImpl(IEquipement repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Equipement enregistrer(Equipement equipement) {
        return repository.save(equipement);
    }

    @Override
    public List<Equipement> lister() {
        return repository.findAll();
    }

    @Override
    public Optional<Equipement> chercherParId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public void supprimerParId(Long id) {
        repository.deleteById(id);
    }
}
