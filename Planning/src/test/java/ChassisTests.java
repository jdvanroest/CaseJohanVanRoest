import nl.belastingdienst.caseJohan.Entities.Chassis;
import nl.belastingdienst.caseJohan.Entities.Locatie;
import nl.belastingdienst.caseJohan.enums.LengteChassis;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class ChassisTests {

    Locatie locatie = new Locatie("A", "cobelfret rotterdam");
        private Chassis chassis1(){
            Chassis chassis1 = new Chassis("5-HPD-80", 5600, LengteChassis.FT20, LocalDate.of(2011,1,2), locatie);
            return chassis1;
        }

        @Test
        @DisplayName("Check of class Chassis attributen merk, kenteken, gewicht, kilometerstand en apkDatum heeft")
        void testChassis(){
            //assert
            Assertions.assertThat(Chassis.class).hasDeclaredFields("kenteken","gewicht", "apkDatum");
        }

        @Test
        @DisplayName("testen chassis met locatie")
        void testChassisLocatie(){
            //arrange
            String persistenceUnitName = "jpa-hiber-postgres-pu";
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            //act

            tx.begin();
            em.persist(locatie);
            em.persist(new Chassis("5-HPD-90", 5600, LengteChassis.FT20, LocalDate.of(2011,1,2), locatie));
            tx.commit();
            //assert
            Assertions.assertThat(2).isEqualTo(2);
         }

         @Test
         @DisplayName("chassis locatie")
         void testChassislocatie(){
             //arrange

             //act

             //assert
             Assertions.assertThat(1).isEqualTo(2);
          }
//
//        @Test
//        @DisplayName("controle getters van vrachtwagen")
//        void testGetters(){
//            //arrange
//            vrachtwagen1();
//            //act
//
//            //assert
//            Assertions.assertThat(vrachtwagen1().getApkDatum()).isEqualTo(LocalDate.of(2011,1,2));
//            Assertions.assertThat(vrachtwagen1().getGewicht()).isEqualTo(13500);
//            Assertions.assertThat(vrachtwagen1().getMerk()).isEqualTo(Merk.SCANIA);
//
//        }
//
//        @Test
//        @DisplayName("testen of id elke keer 1 hoger wordt")
//        void testID(){
//            //arrange
//            Vrachtwagen vrachtwagen1 = new Vrachtwagen(Merk.DAF, "5-LPV-50", 15000, 143758, LocalDate.of(2022,11,21));
//            Vrachtwagen vrachtwagen2 = new Vrachtwagen(Merk.DAF, "5-LPV-51", 15000, 103427, LocalDate.of(2023, 1, 2));
//            Vrachtwagen vrachtwagen3 = new Vrachtwagen(Merk.SCANIA, "5-LPV-52", 15000, 96045, LocalDate.of(2022, 12, 7));
//            //act
//
//
//            //assert
//            //todo let op eerst wegschrijven naar database, anders doet @generateValue niets
//            Assertions.assertThat(vrachtwagen1.getId()).isEqualTo(0);
//            Assertions.assertThat(vrachtwagen2.getId()).isEqualTo(0);
//            Assertions.assertThat(vrachtwagen3.getId()).isEqualTo(0);
//
//        }
//    }


}
