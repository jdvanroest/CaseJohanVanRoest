package nl.belastingdienst.caseJohan;

import nl.belastingdienst.caseJohan.enums.LengteChassis;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Chassis {
    @Id
    @GeneratedValue
    private int id;
    private String kenteken;
    private int gewicht;
    private LengteChassis lengteChassis;
    private LocalDate apkdatum;

    public Chassis(String kenteken, int gewicht, LengteChassis lengteChassis, LocalDate apkdatum){
        this.kenteken = kenteken;
        this.gewicht = gewicht;
        this.lengteChassis = lengteChassis;
        this.apkdatum = apkdatum;
    }
    public Chassis(){

    }

}
