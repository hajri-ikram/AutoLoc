package tn.esprit.ikramhajri4cee18.service;
import org.springframework.stereotype.Service;
import tn.esprit.ikramhajri4cee18.domain.Reservation;
import tn.esprit.ikramhajri4cee18.domain.StatutReservation;
import tn.esprit.ikramhajri4cee18.repositories.IReservation;
import java.util.List;
import java.time.LocalDate;

@Service
public class ReservationService {

    private final IReservation reservationRepository;

    public ReservationService(IReservation reservationRepository) {
        this.reservationRepository = reservationRepository;
    }
    public Reservation ajouter(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
    public List<Reservation> afficherTous() {
        return reservationRepository.findAll();
    }
    public Reservation chercherParId(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Réservation introuvable"));
    }
    public Reservation modifier(Long id, Reservation nouvelleReservation) {
        Reservation reservation = chercherParId(id);

        reservation.setDateDebut(nouvelleReservation.getDateDebut());
        reservation.setDateFin(nouvelleReservation.getDateFin());
        reservation.setStatut(nouvelleReservation.getStatut());
        reservation.setClient(nouvelleReservation.getClient());
        reservation.setVehicule(nouvelleReservation.getVehicule());

        return reservationRepository.save(reservation);
    }
    public void supprimer(Long id) {
        Reservation reservation = chercherParId(id);
        reservationRepository.delete(reservation);
    }
    public List<Reservation> rechercherParStatut(StatutReservation statut) {
        return reservationRepository.findByStatut(statut);
    }
    public List<Reservation> rechercherParClient(Long idClient) {
        return reservationRepository.findByClient_IdClient(idClient);
    }
    public List<Reservation> rechercherParVehicule(Long idVehicule) {
        return reservationRepository.findByVehicule_IdVehicule(idVehicule);
    }
    public List<Reservation> rechercherParPeriode(
            LocalDate debut, LocalDate fin) {
        return reservationRepository.findByDateDebutBetween(debut, fin);
    }
    public List<Reservation> rechercherParClientEtStatut(
            Long idClient, StatutReservation statut) {
        return reservationRepository
                .findByClient_IdClientAndStatut(idClient, statut);
    }
}
