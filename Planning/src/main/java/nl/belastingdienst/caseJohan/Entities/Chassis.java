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

    @OneToOne(mappedBy = "chassis")
    Vrachtwagen vrachtwagen;

    public Chassis(String kenteken, int gewicht, LengteChassis lengteChassis, LocalDate apkdatum){
        this.kenteken = kenteken;
        this.gewicht = gewicht;
        this.lengteChassis = lengteChassis;
        this.apkDatum = apkdatum;
    }
    public Chassis(){

    }

}
