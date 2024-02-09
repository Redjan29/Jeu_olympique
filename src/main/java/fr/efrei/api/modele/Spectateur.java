package fr.efrei.api.modele;

import fr.efrei.api.modele.Reservation;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "SPECTATEUR")
public class Spectateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nom;
    private String email;
    private String password;



    //Un spectateur peut avoir plusieurs réservations
    @OneToMany(mappedBy = "spectateur", cascade = CascadeType.ALL)
    private List<Reservation> reservation;


    public Spectateur() {
    }


    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public List<Reservation> getReservation() {
        return reservation;
    }
    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }



}

