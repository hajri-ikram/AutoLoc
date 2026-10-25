package tn.esprit.ikramhajri4cee18.service;
import java.util.List;
import java.util.Optional;
import tn.esprit.ikramhajri4cee18.domain.Client;
public interface IClientService {

    Client enregistrer(Client client);

    List<Client> lister();

    Optional<Client> chercherParId(Long id);

    void supprimerParId(Long id);
}
