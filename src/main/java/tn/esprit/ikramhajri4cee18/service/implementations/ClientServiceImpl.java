package tn.esprit.ikramhajri4cee18.service.implementations;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.ikramhajri4cee18.domain.Client;
import tn.esprit.ikramhajri4cee18.repositories.IClient;
import tn.esprit.ikramhajri4cee18.service.IClientService;
@Service
@Transactional(readOnly = true)
public class ClientServiceImpl implements IClientService {

    private final IClient repository;

    public ClientServiceImpl(IClient repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Client enregistrer(Client client) {
        return repository.save(client);
    }

    @Override
    public List<Client> lister() {
        return repository.findAll();
    }

    @Override
    public Optional<Client> chercherParId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public void supprimerParId(Long id) {
        repository.deleteById(id);
    }
}
