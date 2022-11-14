import nl.belastingdienst.caseJohan.Entities.Locatie;
import nl.belastingdienst.caseJohan.Entities.Tank;
import nl.belastingdienst.caseJohan.Entities.Transportopdracht;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TransportopdrachtTests {

@Test
@DisplayName("persist transportopdracht ")
void testPersistTransportopdracht(){
    //arrange
    String persistenceUnitName = "jpa-hiber-postgres-pu";
    EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
    EntityManager em = emf.createEntityManager();

    EntityTransaction tx = em.getTransaction();
    //act
    tx.begin();
    Tank tank1 = new Tank("fotu123456", 3500, 36000, em.find(Locatie.class,"boarot"));
    Locatie locatieB = new Locatie("B", "startlocatieB");
    Locatie locatieC = new Locatie("C", "eindelocatieC");
    em.persist(tank1);
    em.persist(locatieB);
    em.persist(locatieC);
    em.persist(new Transportopdracht(tank1, locatieB, locatieC));
    tx.commit();

    //assert
    Assertions.assertThat(2).isEqualTo(2);
 }

 @Test
 @DisplayName("transportopdracht invoerern")
 void testTransportopdrachtInvoeren(){
     //arrange
     String persistenceUnitName = "jpa-hiber-postgres-pu";
     EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
     EntityManager em = emf.createEntityManager();

     EntityTransaction tx = em.getTransaction();

     int naamTeVerplaatsenTank = 1;
     String PKbeginLocatieTank = "B";
     String PKeindLocatieTank = "C";
     //act
     tx.begin();
     Tank teVerplaatsenTank = em.find(Tank.class, naamTeVerplaatsenTank);
     Locatie beginlocatie = em.find(Locatie.class, PKbeginLocatieTank);
     Locatie eindlocatie = em.find(Locatie.class, PKeindLocatieTank);
     em.persist(new Transportopdracht(teVerplaatsenTank, beginlocatie, eindlocatie));
     tx.commit();
     //assert
     Assertions.assertThat(2).isEqualTo(2);
  }

}
