package fr.efrei.api.service;

import fr.efrei.api.modele.Spectateur;
import fr.efrei.api.repository.SpectateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpectateurService {

    @Autowired
    private SpectateurRepository spectateurRepository;

    public Spectateur add(Spectateur spectateur) {
        return spectateurRepository.save(spectateur);
    }

    public Spectateur getSpectateurById(Long id) {
        return spectateurRepository.findById(id).orElse(null);
    }

    public Spectateur updateSpectateur(Long id, Spectateur updatedSpectateur) {

        Spectateur existingSpectateur = getSpectateurById(id);
        if (existingSpectateur != null) {
            existingSpectateur.setNom(updatedSpectateur.getNom());
            existingSpectateur.setEmail(updatedSpectateur.getEmail());

            return spectateurRepository.save(existingSpectateur);
        }
        return null;
    }

    public void deleteSpectateur(Long id) {
        spectateurRepository.deleteById(id);
    }

    public List<Spectateur> getAllSpectateurs() {
        return spectateurRepository.findAll();
    }
}
