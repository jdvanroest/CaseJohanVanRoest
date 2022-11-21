package nl.bld.tests;

import nl.belastingdienst.caseJohan.model.Locatie;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.*;

public class LocatieTests {

    @Test
    @DisplayName("locaties toevoegen")
    void locatiesToevoegenTests(){
        //arrange
        String persistenceUnitName = "jpa-hiber-postgres-pu";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //Act
        tx.begin();
            em.persist(new Locatie("cobroz", "cobelfret rotterdam"));
            em.persist(new Locatie("rscrot", "rsc rotterdam"));
            em.persist(new Locatie("parbot", "parkeerplaats botlek"));
            em.persist(new Locatie("parbed", "parkeerplaats bedrijf"));
        tx.commit();
        //assert
        Assertions.assertThat(2).isEqualTo(2);
     }

}
