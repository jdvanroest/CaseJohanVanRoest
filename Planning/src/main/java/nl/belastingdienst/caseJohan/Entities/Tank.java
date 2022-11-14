package nl.belastingdienst.caseJohan.Entities;

import javax.persistence.*;

@Entity
public class Tank {
    @Id
    @GeneratedValue
    private int id;
    private String naam;
    private int gewicht;
    private int inhoud; // inhoud in liters

    @OneToOne
    Locatie locatieTank;

    public Tank(String naam, int gewicht, int inhoud) {
        this.naam = naam;
        this.gewicht = gewicht;
        this.inhoud = inhoud;
    }

    public Tank(){ }


    public int getId() {
        return id;
    }
}
