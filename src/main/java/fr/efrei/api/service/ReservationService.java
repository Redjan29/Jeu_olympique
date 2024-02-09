package fr.efrei.api.service;

import fr.efrei.api.modele.Reservation;
import fr.efrei.api.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Optional<Reservation> updateReservation(Long id, Reservation updatedReservation) {
        return getReservationById(id).map(r -> {
            r.setEvenement(updatedReservation.getEvenement());
            r.setSpectateur(updatedReservation.getSpectateur());

            return reservationRepository.save(r);
        });
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
