package tn.esprit.ikramhajri4cee18.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ikramhajri4cee18.domain.Vehicule;

public interface VehiculeRepository
        extends JpaRepository<Vehicule, Long> {

    boolean existsByImmatriculation(String immatriculation);
}