package nl.belastingdienst.caseJohan.Entities;

import nl.belastingdienst.caseJohan.enums.LengteChassis;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class Chassis {
    @Id
    @GeneratedValue
    private int id;
   @Column(unique = true)
    private String kenteken;
    private int gewicht;
    private LengteChassis lengteChassis;
    private LocalDate apkDatum;

    @OneToOne
    Locatie locatie;
    @OneToOne(mappedBy = "chassis")
    Vrachtwagen vrachtwagen;

    public Chassis(String kenteken, int gewicht, LengteChassis lengteChassis, LocalDate apkdatum, Locatie locatie){
        this.kenteken = kenteken;
        this.gewicht = gewicht;
        this.lengteChassis = lengteChassis;
        this.apkDatum = apkdatum;
        this.locatie = locatie;
    }
    public Chassis(){

    }

    public String getKenteken() {
        return kenteken;
    }

    public void setKenteken(String kenteken) {
        this.kenteken = kenteken;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Locatie getLocatie(){
        return locatie;
    }
}
