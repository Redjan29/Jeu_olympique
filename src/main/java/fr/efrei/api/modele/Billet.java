package fr.efrei.api.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "BILLET")
@Getter
@Setter
public class Billet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //Un billet peut être lié à plusieurs réservations
    @ManyToOne
    @JoinColumn(name = "evenement_id")
    private Evenement evenement;

    private double prix;


}
