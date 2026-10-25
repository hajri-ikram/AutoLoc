package tn.esprit.ikramhajri4cee18.service.implementations;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.ikramhajri4cee18.domain.contrat;
import tn.esprit.ikramhajri4cee18.repositories.IContrat;
import tn.esprit.ikramhajri4cee18.service.IContratService;
@Service
@Transactional(readOnly = true)
public class ContratServiceImpl implements IContratService {

    private final IContrat repository;

    public ContratServiceImpl(IContrat repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public contrat enregistrer(contrat contrat) {
        return repository.save(contrat);
    }

    @Override
    public List<contrat> lister() {
        return repository.findAll();
    }

    @Override
    public Optional<contrat> chercherParId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public void supprimerParId(Long id) {
        repository.deleteById(id);
    }
}