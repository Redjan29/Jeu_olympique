package fr.efrei.api.repository;

import fr.efrei.api.modele.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement, Long> {
    // Ajoutez des méthodes spécifiques au repository si nécessaire
}
