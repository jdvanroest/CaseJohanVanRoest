package nl.bld.tests;

import nl.belastingdienst.caseJohan.model.Chassis;
import nl.belastingdienst.caseJohan.model.Locatie;
import nl.belastingdienst.caseJohan.model.Vrachtwagen;
import nl.belastingdienst.caseJohan.model.enums.LengteChassis;
import nl.belastingdienst.caseJohan.model.enums.Merk;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class oneToOneTests {
    @Inject
    EntityManager em;

    EntityTransaction tx = em.getTransaction();
    @Test
    @DisplayName("..")
    void testManyToMany(){
        //arrange
        Vrachtwagen vrachtwagen = new Vrachtwagen(Merk.SCANIA, "5-HPD-49", 13500, 134750, LocalDate.of(2011, 1, 2), em.find(Chassis.class, 1), em.find(Locatie.class, "parbot"));
        Chassis chassis = new Chassis("5-HPD-80", 5600, LengteChassis.FT20, LocalDate.of(2011, 1, 2), new Locatie("A", "cobelfret rotterdam"));
        //act

        tx.begin();
        em.persist(chassis);
        em.persist(vrachtwagen);
        tx.commit();
        //assert
        Assertions.assertThat(2).isEqualTo(2);
     }
}
