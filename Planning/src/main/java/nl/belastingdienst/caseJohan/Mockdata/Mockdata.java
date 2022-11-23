package nl.belastingdienst.caseJohan.Mockdata;

import nl.belastingdienst.caseJohan.model.*;
import nl.belastingdienst.caseJohan.model.enums.LengteChassis;
import nl.belastingdienst.caseJohan.model.enums.Merk;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import javax.persistence.EntityTransaction;
import java.time.LocalDate;

public class Mockdata {
    @Inject
    EntityManager em;

    public void mockdataInvoeren() {

        EntityTransaction tx = em.getTransaction();
        tx.begin();
            // Locatie invoeren
        em.persist(new Locatie("cobroz", "cobelfret rotterdam"));
        em.persist(new Locatie("rscrot", "rsc rotterdam"));
        em.persist(new Locatie("parbot", "parkeerplaats botlek"));
        em.persist(new Locatie("parbed", "parkeerplaats bedrijf"));
        em.persist(new Locatie("boarot", "boasso rotterdam"));

            // chassis invoeren
        em.persist(new Chassis("5-HPD-80", 4700, LengteChassis.FT20, LocalDate.of(2022,12,2), em.find(Locatie.class, "parbed")));
        em.persist(new Chassis("5-HPD-81", 4700, LengteChassis.FT20, LocalDate.of(2023,01,5), em.find(Locatie.class, "parbed")));
        em.persist(new Chassis("5-HPD-82", 4700, LengteChassis.FT20, LocalDate.of(2022,12,16), em.find(Locatie.class, "parbed")));
        em.persist(new Chassis("5-HPD-83", 4700, LengteChassis.FT20, LocalDate.of(2022,12,19), em.find(Locatie.class, "parbed")));
        em.persist(new Chassis("5-HPD-84", 4700, LengteChassis.FT20, LocalDate.of(2023,05,2), em.find(Locatie.class, "parbed")));
        em.persist(new Chassis("5-HPD-85", 4700, LengteChassis.FT20, LocalDate.of(2023,03,10), em.find(Locatie.class, "parbed")));
        em.persist(new Chassis("5-HPD-86", 4700, LengteChassis.FT20, LocalDate.of(2023,07,13), em.find(Locatie.class, "parbed")));
        em.persist(new Chassis("5-HPD-87", 4700, LengteChassis.FT20, LocalDate.of(2023,05,25), em.find(Locatie.class, "parbed")));
        em.persist(new Chassis("5-HPD-88", 4700, LengteChassis.FT20, LocalDate.of(2023,02,21), em.find(Locatie.class, "parbed")));
        em.persist(new Chassis("5-HPD-89", 4700, LengteChassis.FT20, LocalDate.of(2023,03,30), em.find(Locatie.class, "parbed")));
            // vrachtwagens invoeren
        em.persist(new Vrachtwagen(Merk.SCANIA, "5-LPV-50",8500, 143758, LocalDate.of(2022,11,21), em.find(Chassis.class, 1), em.find(Locatie.class, "parbed")));
        em.persist(new Vrachtwagen(Merk.SCANIA, "5-LPV-51",8500, 103427, LocalDate.of(2023,1,2),em.find(Chassis.class, 2), em.find(Locatie.class, "parbed")));
        em.persist(new Vrachtwagen(Merk.SCANIA, "5-LPV-52",8500, 96045, LocalDate.of(2022,12,7),em.find(Chassis.class, 3), em.find(Locatie.class, "parbed")));
        em.persist(new Vrachtwagen(Merk.SCANIA, "5-LPV-53",8500, 183507, LocalDate.of(2023,5,15),em.find(Chassis.class, 4), em.find(Locatie.class, "parbed")));
        em.persist(new Vrachtwagen(Merk.SCANIA, "5-LPV-54",8500, 305467, LocalDate.of(2023,10,17),em.find(Chassis.class, 5), em.find(Locatie.class, "parbed")));
            // tankjes invoeren
        em.persist(new Tank("fotu123456", 3100, 33000, em.find(Locatie.class, "cobroz")));
        em.persist(new Tank("fotu123457", 3100, 33000, em.find(Locatie.class, "cobroz")));
        em.persist(new Tank("fotu123458", 3100, 33000, em.find(Locatie.class, "rscrot")));
        em.persist(new Tank("fotu123459", 3100, 33000, em.find(Locatie.class, "rscrot")));
        em.persist(new Tank("fotu123460", 3100, 33000, em.find(Locatie.class, "rscrot")));
        em.persist(new Tank("fotu123461", 3100, 33000, em.find(Locatie.class, "rscrot")));
        em.persist(new Tank("fotu123462", 3100, 33000, em.find(Locatie.class, "rscrot")));
            // transportopdrachten invoeren
        em.persist(new Transportopdracht(em.find(Tank.class, 1), em.find(Locatie.class, "cobroz"), em.find(Locatie.class, "rscrot")));
        em.persist(new Transportopdracht(em.find(Tank.class, 2), em.find(Locatie.class, "cobroz"), em.find(Locatie.class, "rscrot")));
        em.persist(new Transportopdracht(em.find(Tank.class, 3), em.find(Locatie.class, "rscrot"), em.find(Locatie.class, "cobroz")));
        em.persist(new Transportopdracht(em.find(Tank.class, 4), em.find(Locatie.class, "rscrot"), em.find(Locatie.class, "cobroz")));

        tx.commit();
    }

}
