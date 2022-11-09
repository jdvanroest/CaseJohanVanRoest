package nl.belastingdienst.caseJohan;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Vrachtwagen {
    @Id

    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    //todo check how generatedvalue works
    private int id;
    private Merk merk;
    private String kenteken;
    private int gewicht; // ledig gewicht van de vrachtwagen in kilo's
    private int kilometerstand;

    private LocalDate apkDatum;

    public Vrachtwagen(int id, Merk merk, String kenteken, int gewicht, int kilometerstand, LocalDate apkDatum) {
        this.id = id;
        this.merk = merk;
        setKenteken(kenteken);
        this.gewicht = gewicht;
        setKilometerstand(kilometerstand);
        setApkDatum(apkDatum);
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
}
