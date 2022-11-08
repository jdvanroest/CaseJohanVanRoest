import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.postgresql.util.PSQLException;

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
    void persistBookWithoutAGeneratedValue(){
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
        tx.commit();
    }
}
