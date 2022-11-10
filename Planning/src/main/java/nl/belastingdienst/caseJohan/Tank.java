package nl.belastingdienst.caseJohan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tank {
    @Id
    @GeneratedValue
    private int id;
    private String naam;
    private int gewicht;
    private int inhoud; // inhoud in liters

    public Tank(String naam, int gewicht, int inhoud) {
        this.naam = naam;
        this.gewicht = gewicht;
        this.inhoud = inhoud;
    }

    public Tank(){ }


}
