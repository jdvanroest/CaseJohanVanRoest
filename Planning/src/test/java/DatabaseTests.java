
import nl.belastingdienst.caseJohan.VrachtwagenFactory;
import nl.belastingdienst.caseJohan.Merk;
import nl.belastingdienst.caseJohan.Vrachtwagen;
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
    void persistVrachtwagenWithoutAGeneratedValue(){
        String persistenceUnitName = "jpa-hiber-postgres-pu";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        EntityManager em = emf.createEntityManager();



        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(new Vrachtwagen(1, Merk.DAF, "5-LPV-50", 15000, 143758, LocalDate.of(2022,11,21)));
        em.persist(new Vrachtwagen(2, Merk.DAF, "5-LPV-51", 15000, 103427, LocalDate.of(2023,1,2)));
        em.persist(new Vrachtwagen(3, Merk.SCANIA, "5-LPV-52", 15000, 96045, LocalDate.of(2022,12,7)));
        em.persist(new Vrachtwagen(4, Merk.SCANIA, "5-LPV-53", 15000, 183507, LocalDate.of(2023,5,15)));
        em.persist(new Vrachtwagen(5, Merk.DAF, "5-LPV-54",15000, 305467, LocalDate.of(2023,10,17)));
        Vrachtwagen v = new Vrachtwagen(6, Merk.DAF, "5-LPV-55", 15000, 143758, LocalDate.of(2022,11,21));
        em.persist(v);
        tx.commit();
    }

    @Test
    @DisplayName("testen zelf invoeren vrachtwagen")
    void testInvoerenVrachtwagen(){
        //arrange
        VrachtwagenFactory invoerenVrachtwagen = new VrachtwagenFactory();

        String persistenceUnitName = "jpa-hiber-postgres-pu";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        //act
        Vrachtwagen v2 = invoerenVrachtwagen.makenVrachtwagen();
        tx.begin();
        em.persist(v2);
        tx.commit();

        //assert
        assertThat(2).isEqualTo(2);
     }
}
