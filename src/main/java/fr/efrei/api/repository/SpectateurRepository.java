package fr.efrei.api.repository;

import fr.efrei.api.modele.Spectateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpectateurRepository extends JpaRepository<Spectateur, Long> {

}
