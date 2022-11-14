package nl.belastingdienst.caseJohan.Entities;

import nl.belastingdienst.caseJohan.enums.Merk;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Vrachtwagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Merk merk;
    @Column(unique = true)
    private String kenteken;
    private int gewicht; // ledig gewicht van de vrachtwagen in kilo's
    private int kilometerstand;

    @OneToOne
    Chassis chassis;
    @OneToOne
    Locatie locatieVrachtwagen;

    private LocalDate apkDatum;

    public Vrachtwagen(Merk merk, String kenteken, int gewicht, int kilometerstand, LocalDate apkDatum, Chassis chassis, Locatie locatieVrachtwagen) {
        this.merk = merk;
        setKenteken(kenteken);
        this.gewicht = gewicht;
        setKilometerstand(kilometerstand);
        setApkDatum(apkDatum);
        this.chassis = chassis;
        this.locatieVrachtwagen = locatieVrachtwagen;
    }

    public Vrachtwagen() {

    }

    public int getId() {
        return id;
    }

    public Merk getMerk() {
        return merk;
    }

    public String getKenteken() {
        return kenteken;
    }

    public void setKenteken(String kenteken) {
        this.kenteken = kenteken;
    }

    public int getGewicht() {
        return gewicht;
    }

    public int getKilometerstand() {
        return kilometerstand;
    }

    public void setKilometerstand(int kilometerstand) {
        this.kilometerstand = kilometerstand;
    }

    public LocalDate getApkDatum() {
        return apkDatum;
    }

    public void setApkDatum(LocalDate apkDatum) {
        this.apkDatum = apkDatum;
    }

    public void setLocatieVrachtwagen(Locatie locatieVrachtwagen){this.locatieVrachtwagen = locatieVrachtwagen;}

    public void setChassisAchterVrachtwagen(Chassis chassisVrachtwagen){this.chassis = chassisVrachtwagen;}
}

