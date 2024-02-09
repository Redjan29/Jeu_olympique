package fr.efrei.api.modele;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "RESERVATION")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Une réservation appartient à un utilisateur, un événement et un billet
    @ManyToOne
    @JoinColumn(name = "spectateur_id", referencedColumnName = "id")
    private Spectateur spectateur;


    @ManyToOne
    @JoinColumn(name = "evenement_id")
    private Evenement evenement;

    @ManyToOne
    @JoinColumn(name = "billet_id")
    private Billet billet;

    private int quantity;
    private double total_price;
    private String payment_status;


    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Spectateur getSpectateur() {
        return spectateur;
    }

    public void setSpectateur(Spectateur spectateur) {
        this.spectateur = spectateur;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public Billet getBillet() {
        return billet;
    }

    public void setBillet(Billet billet) {
        this.billet = billet;
    }


}
