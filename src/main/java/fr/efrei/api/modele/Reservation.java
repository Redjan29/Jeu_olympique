package fr.efrei.api.modele;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "RESERVATION")
@Getter
@Setter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //Une réservation appartient à un utilisateur, un événement et un billet
    @ManyToOne
    @JoinColumn(name = "spectateur_id")
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





}
