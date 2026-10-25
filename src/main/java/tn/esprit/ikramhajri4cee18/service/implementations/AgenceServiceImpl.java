package tn.esprit.ikramhajri4cee18.service.implementations;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.ikramhajri4cee18.domain.Agence;
import tn.esprit.ikramhajri4cee18.repositories.IAgence;
import tn.esprit.ikramhajri4cee18.service.IAgenceService;
@Service
@Transactional(readOnly = true)
public class AgenceServiceImpl implements IAgenceService {

    private final IAgence repository;

    public AgenceServiceImpl(IAgence repository) {
        this.repository = repository;
    }
@Override
    @Transactional
    public Agence enregistrer(Agence agence) {
        return repository.save(agence);
    }
@Override
    public List<Agence> lister() {
        return repository.findAll();
    }
@Override
    public Optional<Agence> chercherParId(Long id) {
        return repository.findById(id);
    }
@Override
    @Transactional
    public void supprimerParId(Long id) {
        repository.deleteById(id);
    }
}