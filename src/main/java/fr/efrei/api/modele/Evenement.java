package fr.efrei.api.modele;

import fr.efrei.api.modele.Billet;
import jakarta.persistence.*;
import lombok.Data;


import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "EVENEMENT")
public class Evenement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private Date date;



    // Un événement peut avoir plusieurs billets
    @OneToMany(mappedBy = "evenement", cascade = CascadeType.ALL)
    private List<Billet> billets;


    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Billet> getBillets() {
        return billets;
    }

    public void setBillets(List<Billet> billets) {
        this.billets = billets;
    }
}

