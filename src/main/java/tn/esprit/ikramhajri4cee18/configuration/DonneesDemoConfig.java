package tn.esprit.ikramhajri4cee18.configuration;

import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import tn.esprit.ikramhajri4cee18.domain.CategorieVehicule;
import tn.esprit.ikramhajri4cee18.domain.StatutVehicule;
import tn.esprit.ikramhajri4cee18.domain.Vehicule;
import tn.esprit.ikramhajri4cee18.repository.VehiculeRepository;

@Configuration
@Profile("dev")
public class DonneesDemoConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(DonneesDemoConfig.class);

    @Bean
    CommandLineRunner insererVehiculesDemo(VehiculeRepository repository) {
        return args -> {
            insererSiAbsent(repository, "DEMO-001", "Peugeot", "208",
                    CategorieVehicule.CITADINE, "95.00", StatutVehicule.DISPONIBLE);
            insererSiAbsent(repository, "DEMO-002", "Toyota", "Corolla",
                    CategorieVehicule.BERLINE, "145.00", StatutVehicule.LOUE);
            insererSiAbsent(repository, "DEMO-003", "Dacia", "Duster",
                    CategorieVehicule.SUV, "175.00", StatutVehicule.MAINTENANCE);
        };
    }

    private void insererSiAbsent(VehiculeRepository repository, String immatriculation,
                                 String marque, String modele, CategorieVehicule categorie,
                                 String tarifJournalier, StatutVehicule statut) {
        if (repository.existsByImmatriculation(immatriculation)) {
            LOGGER.info("Vehicule de demonstration deja present : {}", immatriculation);
            return;
        }
        Vehicule vehicule = new Vehicule();
        vehicule.setImmatriculation(immatriculation);
        vehicule.setMarque(marque);
        vehicule.setModele(modele);
        vehicule.setCategorie(categorie);
        vehicule.setTarifJournalier(new BigDecimal(tarifJournalier));
        vehicule.setStatut(statut);
        repository.save(vehicule);
        LOGGER.info("Vehicule de demonstration insere : {}", immatriculation);
    }
}