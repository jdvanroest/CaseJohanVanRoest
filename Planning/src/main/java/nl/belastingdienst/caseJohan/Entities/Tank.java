package nl.belastingdienst.caseJohan.Entities;

import javax.persistence.*;

@Entity
public class Tank {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String naam;
    private int gewicht; // gewicht in kilogram
    private int inhoud; // inhoud in liters


    @OneToOne
    Locatie locatieTank;

    public Tank(String naam, int gewicht, int inhoud, Locatie locatieTank) {
        this.naam = naam;
        this.gewicht = gewicht;
        this.inhoud = inhoud;
        this.locatieTank = locatieTank;
    }

    public Tank(){ }


    public int getId() {
        return id;
    }

    public void setLocatieTank(Locatie locatieTank) {
        this.locatieTank = locatieTank;
    }

    public Locatie getLocatieTank() {
        return locatieTank;
    }

    public String getNaam() {
        return naam;
    }
}
