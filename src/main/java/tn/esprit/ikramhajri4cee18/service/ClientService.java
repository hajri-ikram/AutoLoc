package tn.esprit.ikramhajri4cee18.service;
import org.springframework.stereotype.Service;
import tn.esprit.ikramhajri4cee18.domain.Client;
import tn.esprit.ikramhajri4cee18.repositories.IClient;
import java.util.List;
@Service
public class ClientService {
private final IClient clientRepository;
public ClientService(IClient clientRepository) {
        this.clientRepository = clientRepository;
    }
 public Client ajouter(Client client) {
        return clientRepository.save(client);
    }
    public List<Client> afficherTous() {
        return clientRepository.findAll();
    }
    public Client chercherParId(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Client introuvable"));
    }
    public Client modifier(Long id, Client nouveauClient) {
        Client client = chercherParId(id);

        client.setNom(nouveauClient.getNom());
        client.setPrenom(nouveauClient.getPrenom());
        client.setEmail(nouveauClient.getEmail());
        client.setTelephone(nouveauClient.getTelephone());
        client.setNumPermis(nouveauClient.getNumPermis());
        client.setDateInscription(nouveauClient.getDateInscription());

        return clientRepository.save(client);
    }
    public void supprimer(Long id) {
        Client client = chercherParId(id);
        clientRepository.delete(client);
    }
    public List<Client> rechercherParNom(String nom) {
        return clientRepository.findByNom(nom);
    }
    public List<Client> rechercherParEmail(String email) {
        return clientRepository.findByEmailIgnoreCase(email);
    }
    public boolean emailExiste(String email) {
        return clientRepository.existsByEmail(email);
    }
}
