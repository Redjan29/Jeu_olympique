package fr.efrei.api.modele;

import fr.efrei.api.modele.Billet;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "EVENEMENT")
@Getter
@Setter
public class Evenement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private Date date;



    // Un événement peut avoir plusieurs billets
    @OneToMany(mappedBy = "evenement", cascade = CascadeType.ALL)
    private List<Billet> billets;


}

