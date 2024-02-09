package fr.efrei.api.repository;

import fr.efrei.api.modele.Billet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BilletRepository extends JpaRepository<Billet, Long> {
    // Ajoutez des méthodes spécifiques au repository si nécessaire
}
