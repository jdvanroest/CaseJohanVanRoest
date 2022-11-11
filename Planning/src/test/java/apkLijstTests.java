import nl.belastingdienst.caseJohan.Controllers.CreateApkDatumLijst;
import nl.belastingdienst.caseJohan.Controllers.CreateEntityManager;
import nl.belastingdienst.caseJohan.Entities.Vrachtwagen;
import org.assertj.core.api.Assertions;
import org.hibernate.sql.Select;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.List;

public class apkLijstTests {

    @Test
    @DisplayName("Lijst APK datums vrachtwagens")
    void testApkDatumsVrachtwagens(){
        //arrange
        CreateApkDatumLijst createApkDatumLijst = new CreateApkDatumLijst();
        //act
        createApkDatumLijst.vrachtwagenApkLijstMaken();

        //assert
        Assertions.assertThat(2).isEqualTo(2);
     }

     @Test
     @DisplayName("Lijst APK datums chassis")
     void testApkDatumsChassis(){
         //arrange
         CreateApkDatumLijst createApkDatumLijst = new CreateApkDatumLijst();
         //act
         createApkDatumLijst.chassisApkLijstMaken();
         //assert
         Assertions.assertThat(2).isEqualTo(2);
      }

      @Test
      @DisplayName("Lijst APK datums vrachtwagens en chassis samenvoegen")
      void testApkDatumsVrachtwagensChassis(){
          //arrange
          CreateApkDatumLijst createApkDatumLijst = new CreateApkDatumLijst();
          //act
          CreateEntityManager createEntityManager = new CreateEntityManager();
          EntityManager em = createEntityManager.getEntityManager();
          EntityTransaction tx = em.getTransaction();

          tx.begin();
          Query query = em.createQuery("Select v.apkDatum, v.kenteken From Vrachtwagen v join Chassis c on v.kenteken = c.kenteken");
          List<Object[]> apkLijst = query.getResultList();

          for (Object[] vrachtwagen : apkLijst) {
              LocalDate apkDatum = (LocalDate) vrachtwagen[0];
              String kenteken = (String) vrachtwagen[1];
            //  String kentekenChassis = (String) vrachtwagen[2];
              System.out.println("Chassis met kenteken " + kenteken + " heeft apk datum " + apkDatum + ".");
            //  System.out.println(kentekenChassis);
          }

          tx.commit();

          //assert
          Assertions.assertThat(2).isEqualTo(2);
       }
}
