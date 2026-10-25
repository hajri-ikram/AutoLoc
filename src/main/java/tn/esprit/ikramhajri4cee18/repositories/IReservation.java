
package tn.esprit.ikramhajri4cee18.repositories;

import tn.esprit.ikramhajri4cee18.domain.Reservation;

import org.springframework.data.jpa.repository.JpaRepository;


public interface IReservation
        extends JpaRepository<Reservation, Long> {

}
