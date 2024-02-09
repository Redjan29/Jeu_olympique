package fr.efrei.api.modele;

import fr.efrei.api.modele.Reservation;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "SPECTATEUR")
@Getter
@Setter
public class Spectateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String nom;
    private String email;
    private String password;



    //Un spectateur peut avoir plusieurs réservations
    @OneToMany(mappedBy = "spectateur", cascade = CascadeType.ALL)
    private List<Reservation> reservation;


    public Spectateur() {
    }





}

