package fr.efrei.api.modele;

import jakarta.persistence.*;

@Entity
@Table(name = "BILLET")
public class Billet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //Un billet peut être lié à plusieurs réservations
    @ManyToOne
    @JoinColumn(name = "evenement_id")
    private Evenement evenement;

    private double prix;
    private int quantite;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
