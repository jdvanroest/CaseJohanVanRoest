package nl.belastingdienst.caseJohan.model;

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

    public String getLocatiecode() {
        return locatiecode;
    }

    public String getNaam() {
        return naam;
    }
}
