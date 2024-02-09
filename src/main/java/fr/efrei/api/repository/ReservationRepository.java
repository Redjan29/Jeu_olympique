package fr.efrei.api.repository;

import fr.efrei.api.modele.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // Ajoutez des méthodes spécifiques au repository si nécessaire
}
