package nl.belastingdienst.caseJohan.Entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Transportopdracht {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    int id;
    @OneToOne
    Tank tank;
    @OneToOne
    Locatie beginlocatie;



    @OneToOne
    Locatie eindlocatie;

    boolean uitgevoerd;

    @OneToOne
    Vrachtwagen vrachtwagen;

    public Transportopdracht(Tank tank, Locatie beginlocatie, Locatie eindlocatie){
        this.tank = tank;
        this.beginlocatie = beginlocatie;
        this.eindlocatie = eindlocatie;
        this.uitgevoerd = false;
        this.vrachtwagen = null;
    }

    public Transportopdracht(){
    }

    public Vrachtwagen getVrachtwagen(){
        return this.vrachtwagen;
    }

    public void setVrachtwagen(Vrachtwagen vrachtwagen){
        this.vrachtwagen = vrachtwagen;
    }
    public void setUitgevoerd(Boolean uitgevoerd){
        this.uitgevoerd = uitgevoerd;
    }
    public Locatie getEindlocatie() {
        return eindlocatie;
    }

    public void setEindlocatie(Locatie eindlocatie) {
        this.eindlocatie = eindlocatie;
    }

    public Tank getTank(){return tank;}
    public int getId() {
        return id;
    }

}
