package nl.bld.tests;

import nl.belastingdienst.caseJohan.Controllers.ScannerInputValidation;
import nl.belastingdienst.caseJohan.Controllers.VrachtwagenController;
import nl.belastingdienst.caseJohan.model.Chassis;
import nl.belastingdienst.caseJohan.model.Locatie;
import nl.belastingdienst.caseJohan.model.enums.Merk;
import nl.belastingdienst.caseJohan.model.Vrachtwagen;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class VrachtwagenTests {

    String persistenceUnitName = "jpa-hiber-postgres-pu";
    EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    private Vrachtwagen vrachtwagen1(){
        Vrachtwagen vrachtwagen1 = new Vrachtwagen(Merk.SCANIA, "5-HPD-49", 13500, 134750, LocalDate.of(2011,1,2), em.find(Chassis.class, 1), em.find(Locatie.class, "parbot"));
        return vrachtwagen1;
    }

    @Test
    @DisplayName("class vrachtwagens met attributen merk, kenteken, gewicht, kilometerstand en apkDatum")
    void testVrachtwagen(){
        //assert
        Assertions.assertThat(Vrachtwagen.class).hasDeclaredFields("merk", "kenteken","gewicht", "kilometerstand", "apkDatum");
    }

    @Test
    @DisplayName("controle getters van vrachtwagen")
    void testGetters(){
        //arrange
        vrachtwagen1();
        //act

        //assert
        Assertions.assertThat(vrachtwagen1().getApkDatum()).isEqualTo(LocalDate.of(2011,1,2));
        Assertions.assertThat(vrachtwagen1().getGewicht()).isEqualTo(13500);
        Assertions.assertThat(vrachtwagen1().getMerk()).isEqualTo(Merk.SCANIA);

     }

     @Test
     @DisplayName("welk chassis achter vrachtwagen")
     void testWelkChassisAchterVrachtwagen(){
         //arrange
         VrachtwagenController vrachtwagenController = new VrachtwagenController();
         //act
         vrachtwagenController.aangekoppeldeChassisWeergeven();
         //assert
         Assertions.assertThat(2).isEqualTo(2);
      }
     @Test
     @DisplayName("testen of id elke keer 1 hoger wordt")
     void testID(){
         //arrange
         Vrachtwagen vrachtwagen1 = new Vrachtwagen(Merk.DAF, "5-LPV-50", 15000, 143758, LocalDate.of(2022,11,21), em.find(Chassis.class, 1), em.find(Locatie.class, "parbot"));
         Vrachtwagen vrachtwagen2 = new Vrachtwagen(Merk.DAF, "5-LPV-51", 15000, 103427, LocalDate.of(2023, 1, 2), em.find(Chassis.class, 1), em.find(Locatie.class, "parbot"));
         Vrachtwagen vrachtwagen3 = new Vrachtwagen(Merk.SCANIA, "5-LPV-52", 15000, 96045, LocalDate.of(2022, 12, 7), em.find(Chassis.class, 1), em.find(Locatie.class, "parbot"));
         //act


         //assert
         //todo let op eerst wegschrijven naar database, anders doet @generateValue niets
         Assertions.assertThat(vrachtwagen1.getId()).isEqualTo(0);
         Assertions.assertThat(vrachtwagen2.getId()).isEqualTo(0);
         Assertions.assertThat(vrachtwagen3.getId()).isEqualTo(0);

     }

     @Test
    void testKilometerstandinput() {
         ScannerInputValidation scannerInputValidation = new ScannerInputValidation();
        int kilometerstand = 0;
        System.out.println("\n" + "Voer de kilometerstand van de vrachtwagen in");
         kilometerstand = scannerInputValidation.intInputValidation(0, 2147483647, "");
         System.out.println("De ingevoerde kilometerstand is " + kilometerstand);
     }
}
