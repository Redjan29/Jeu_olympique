package fr.efrei.api.controller;

import fr.efrei.api.modele.Spectateur;
import fr.efrei.api.service.SpectateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/spectateurs")
public class SpectateurController {

    @Autowired
    private SpectateurService spectateurService;

    @GetMapping
    public ResponseEntity<List<Spectateur>> getAllSpectateurs() {
        List<Spectateur> spectateurs = spectateurService.getAllSpectateurs();
        return ResponseEntity.ok(spectateurs);
    }

    // Vérifier qu'il y'a un spectateur
    @GetMapping("read/{id}")
    public ResponseEntity<Spectateur> getSpectateurById(@PathVariable Long id) {
        Spectateur spectateur = spectateurService.getSpectateurById(id);
        if (spectateur != null) {
            return ResponseEntity.ok(spectateur);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Ajouter un spectateur
    @PostMapping("/create")
    public Spectateur create(@RequestBody Spectateur spectateur){
        return spectateurService.add(spectateur);
    }


    // Mettre a jour
    @PutMapping("update/{id}")
    public ResponseEntity<Spectateur> updateSpectateur(@PathVariable Long id, @RequestBody Spectateur updatedSpectateur) {
        Spectateur spectateur = spectateurService.updateSpectateur(id, updatedSpectateur);
        if (spectateur != null) {
            return ResponseEntity.ok(spectateur);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // Supprimer un spectateur
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteSpectateur(@PathVariable Long id) {
        spectateurService.deleteSpectateur(id);
        return ResponseEntity.ok().build();
    }
}

