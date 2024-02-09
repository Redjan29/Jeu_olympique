package fr.efrei.api.controller;

import fr.efrei.api.modele.Billet;
import fr.efrei.api.service.BilletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/billets")
public class BilletController {

    @Autowired
    private BilletService billetService;

    @GetMapping
    public ResponseEntity<List<Billet>> getAllBillets() {
        return ResponseEntity.ok(billetService.getAllBillets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Billet> getBilletById(@PathVariable Long id) {
        return billetService.getBilletById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<Billet> createBillet(@RequestBody Billet billet) {
        return ResponseEntity.ok(billetService.createBillet(billet));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Billet> updateBillet(@PathVariable Long id, @RequestBody Billet updatedBillet) {
        return billetService.updateBillet(id, updatedBillet)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBillet(@PathVariable Long id) {
        billetService.deleteBillet(id);
        return ResponseEntity.ok().build();
    }
}
