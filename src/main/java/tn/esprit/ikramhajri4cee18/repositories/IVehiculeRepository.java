package tn.esprit.ikramhajri4cee18.repositories;
import tn.esprit.ikramhajri4cee18.domain.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IVehiculeRepository
        extends JpaRepository<Vehicule, Long> {

}
