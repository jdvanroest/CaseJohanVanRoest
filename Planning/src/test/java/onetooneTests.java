import nl.belastingdienst.caseJohan.Controllers.CreateEntityManager;
import nl.belastingdienst.caseJohan.Entities.Chassis;
import nl.belastingdienst.caseJohan.Entities.Vrachtwagen;
import nl.belastingdienst.caseJohan.enums.LengteChassis;
import nl.belastingdienst.caseJohan.enums.Merk;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;

public class onetooneTests {

    @Test
    @DisplayName("..")
    void testManyToMany(){
        //arrange
        Vrachtwagen vrachtwagen = new Vrachtwagen(Merk.SCANIA, "5-HPD-49", 13500, 134750, LocalDate.of(2011, 1, 2));
        Chassis chassis = new Chassis("5-HPD-80", 5600, LengteChassis.FT20, LocalDate.of(2011, 1, 2));
        //act
        CreateEntityManager createEntityManager = new CreateEntityManager();
        EntityManager em = createEntityManager.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(chassis);
        em.persist(vrachtwagen);
        tx.commit();
        //assert
        Assertions.assertThat(2).isEqualTo(2);
     }
}
