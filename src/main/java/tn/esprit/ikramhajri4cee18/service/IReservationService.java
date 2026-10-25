package tn.esprit.ikramhajri4cee18.service;
import tn.esprit.ikramhajri4cee18.domain.Reservation;
import java.util.Optional;

import java.util.List;

public interface IReservationService {

    Reservation enregistrer(Reservation reservation);

    List<Reservation> lister();

    Optional<Reservation> chercherParId(Long id);

    void supprimerParId(Long id);
}