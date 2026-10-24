
package tn.esprit.ikramhajri4cee18.repositories;

import tn.esprit.ikramhajri4cee18.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IClient extends JpaRepository<Client, Long> {

    List<Client> findByNom(String nom);

    List<Client> findByPrenom(String prenom);

    List<Client> findByEmailIgnoreCase(String email);

    List<Client> findByNumPermis(String numPermis);

    boolean existsByEmail(String email);
}
