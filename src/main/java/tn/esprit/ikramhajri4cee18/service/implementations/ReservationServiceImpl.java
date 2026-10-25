
package tn.esprit.ikramhajri4cee18.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.ikramhajri4cee18.domain.Reservation;
import tn.esprit.ikramhajri4cee18.repositories.IReservation;
import tn.esprit.ikramhajri4cee18.service.IReservationService;

@Service
@Transactional(readOnly = true)
public class ReservationServiceImpl implements IReservationService {

    private final IReservation repository;

    public ReservationServiceImpl(IReservation repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Reservation enregistrer(Reservation reservation) {
        return repository.save(reservation);
    }

    @Override
    public List<Reservation> lister() {
        return repository.findAll();
    }

    @Override
    public Optional<Reservation> chercherParId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public void supprimerParId(Long id) {
        repository.deleteById(id);
    }
}
