package tn.esprit.ikramhajri4cee18.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.ikramhajri4cee18.domain.Paiement;
import tn.esprit.ikramhajri4cee18.repositories.IPaiement;
import tn.esprit.ikramhajri4cee18.service.IPaiementService;

@Service
@Transactional(readOnly = true)
public class PaiementServiceImpl implements IPaiementService {

    private final IPaiement repository;

    public PaiementServiceImpl(IPaiement repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Paiement enregistrer(Paiement paiement) {
        return repository.save(paiement);
    }

    @Override
    public List<Paiement> lister() {
        return repository.findAll();
    }

    @Override
    public Optional<Paiement> chercherParId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public void supprimerParId(Long id) {
        repository.deleteById(id);
    }
}