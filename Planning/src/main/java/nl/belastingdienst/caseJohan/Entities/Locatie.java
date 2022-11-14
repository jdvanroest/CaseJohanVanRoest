package nl.belastingdienst.caseJohan.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Locatie {
    @Id
    private String locatiecode;
    private String naam;

    public Locatie(String locatiecode, String naam){
        this.locatiecode = locatiecode;
        this.naam = naam;
    }

    public Locatie(){

    }

    public String toString(){
        return naam;
    }
}
