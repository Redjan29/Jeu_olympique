package fr.efrei.api.service;

import fr.efrei.api.modele.Evenement;
import fr.efrei.api.repository.EvenementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvenementService {

    @Autowired
    private EvenementRepository evenementRepository;

    public List<Evenement> getAllEvenements() {
        return evenementRepository.findAll();
    }

    public Optional<Evenement> getEvenementById(Long id) {
        return evenementRepository.findById(id);
    }

    public Evenement createEvenement(Evenement evenement) {
        return evenementRepository.save(evenement);
    }

    public Optional<Evenement> updateEvenement(Long id, Evenement updatedEvenement) {
        return getEvenementById(id).map(e -> {
            e.setNom(updatedEvenement.getNom());
            e.setDate(updatedEvenement.getDate());
            // ... Mettez à jour d'autres champs si nécessaire
            return evenementRepository.save(e);
        });
    }

    public void deleteEvenement(Long id) {
        evenementRepository.deleteById(id);
    }
}
