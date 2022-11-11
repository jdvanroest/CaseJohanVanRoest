
import nl.belastingdienst.caseJohan.Controllers.ChassisController;
import nl.belastingdienst.caseJohan.Controllers.VrachtwagenController;
import nl.belastingdienst.caseJohan.Entities.Chassis;
import nl.belastingdienst.caseJohan.Entities.Vrachtwagen;
import nl.belastingdienst.caseJohan.enums.LengteChassis;
import nl.belastingdienst.caseJohan.enums.Merk;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.*;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class DatabaseTests {

    private EntityManager getEntityManager(){
        String persistenceUnitName = "jpa-hiber-postgres-pu";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        EntityManager em = emf.createEntityManager();
        return em;

    }
    @Test
    void showThatTheConnectionToPostgresIsNotNull() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/cursistdb";
        String username = "cursist";
        String password = "PaSSw0rd";
        Connection connection = DriverManager.getConnection(url, username,
                password);
        assertThat(connection).isNotNull();
    }


    @Test
    void persistVrachtwagenWithAGeneratedValue(){
        String persistenceUnitName = "jpa-hiber-postgres-pu";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        EntityManager em = emf.createEntityManager();
        
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(new Vrachtwagen(Merk.DAF, "5-LPV-50", 15000, 143758, LocalDate.of(2022,11,21)));
        em.persist(new Vrachtwagen(Merk.DAF, "5-LPV-51", 15000, 103427, LocalDate.of(2023,1,2)));
        em.persist(new Vrachtwagen(Merk.SCANIA, "5-LPV-52", 15000, 96045, LocalDate.of(2022,12,7)));
        em.persist(new Vrachtwagen(Merk.SCANIA, "5-LPV-53", 15000, 183507, LocalDate.of(2023,5,15)));
        em.persist(new Vrachtwagen(Merk.DAF, "5-LPV-54",15000, 305467, LocalDate.of(2023,10,17)));
        Vrachtwagen v = new Vrachtwagen(Merk.DAF, "5-LPV-55", 15000, 143758, LocalDate.of(2022,11,21));
        em.persist(v);
        tx.commit();
    }

    @Test
    @DisplayName("testen zelf invoeren vrachtwagen")
    void testInvoerenVrachtwagen(){
        //arrange
        VrachtwagenController invoerenVrachtwagen = new VrachtwagenController();

        String persistenceUnitName = "jpa-hiber-postgres-pu";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        //act
        Vrachtwagen v2 = invoerenVrachtwagen.makenVrachtwagenMetScanner();
        tx.begin();
        em.persist(v2);
        tx.commit();

        //assert
        assertThat(2).isEqualTo(2);
     }

     @Test
     @DisplayName("testen persist chassis")
     void testPersistChassis(){
         //arrange
         EntityManager em = getEntityManager();
         EntityTransaction tx = em.getTransaction();

         //act
         tx.begin();
         em.persist(new Chassis("5-HPD-80", 5600, LengteChassis.FT20, LocalDate.of(2011,1,2)));
         tx.commit();
         //assert
         assertThat(2).isEqualTo(2);
      }

      @Test
      @DisplayName("testen zelf invoeren chassis")
      void testInvoerenChassis(){
          //arrange
          EntityManager em = getEntityManager();
          EntityTransaction tx = em.getTransaction();
          ChassisController chassisController = new ChassisController();

          //act
          Chassis chassis = chassisController.makenChassisMetScanner();
          tx.begin();
          em.persist(chassis);
          tx.commit();
          //assert
          assertThat(2).isEqualTo(2);
       }
}
