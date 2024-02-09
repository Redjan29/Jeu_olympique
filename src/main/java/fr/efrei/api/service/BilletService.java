package fr.efrei.api.service;

import fr.efrei.api.modele.Billet;
import fr.efrei.api.repository.BilletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BilletService {

    @Autowired
    private BilletRepository billetRepository;

    public List<Billet> getAllBillets() {
        return billetRepository.findAll();
    }

    public Optional<Billet> getBilletById(Long id) {
        return billetRepository.findById(id);
    }

    public Billet createBillet(Billet billet) {
        return billetRepository.save(billet);
    }

    public Optional<Billet> updateBillet(Long id, Billet updatedBillet) {
        return getBilletById(id).map(b -> {
            b.setEvenement(updatedBillet.getEvenement());
            b.setPrix(updatedBillet.getPrix());
            b.setQuantite(updatedBillet.getQuantite());
            // ... Mettez à jour d'autres champs si nécessaire
            return billetRepository.save(b);
        });
    }

    public void deleteBillet(Long id) {
        billetRepository.deleteById(id);
    }
}
