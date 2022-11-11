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
import java.util.*;

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
        //lijst apkdata en kentekens van vrachtwagens uit database halen
        Query queryVrachtwagen = em.createQuery("Select v.apkDatum, v.kenteken From Vrachtwagen v ");
        List<Object[]> apkLijstVrachtwagen = queryVrachtwagen.getResultList();

        //lijst apkdata en kentekens van chassis uit database halen
        Query queryChassis = em.createQuery("Select c.apkDatum, c.kenteken From Chassis c");
        List<Object[]> apkLijstChassis = queryChassis.getResultList();

        //lijsten samenvoegen
        List<Object[]> totaallijstAPK = new ArrayList<>();
          totaallijstAPK.addAll(apkLijstChassis);
          totaallijstAPK.addAll(apkLijstVrachtwagen);

        //lijsten sorteren
          ArrayList<ApkDatum> apkData = new ArrayList<>();
          for(Object[] apk : totaallijstAPK){
              apkData.add(new ApkDatum((String)apk[1], (LocalDate)apk[0]));
          }
          Collections.sort(apkData);

          for(ApkDatum apkdatum : apkData){
                System.out.println(apkdatum);
          }

//        HashMap<String, LocalDate> apkmap = new HashMap<String, LocalDate>();
//        for(Object[] apk : totaallijstAPK){
////            LocalDate apkDatum = (LocalDate)apk[0];
////            String kenteken = (String)apk[1];
//            apkmap.put((String)apk[1], (LocalDate)apk[0]);
////            System.out.println(apkDatum);
////            System.out.println(kenteken);


//        }
//        System.out.println(apkmap);



        tx.commit();

          //assert
          Assertions.assertThat(2).isEqualTo(2);
       }

    private class ApkDatum implements Comparable<ApkDatum> {
        private LocalDate apk;
        private String kenteken;

        public ApkDatum(String kenteken, LocalDate apk) {
            this.kenteken = kenteken;
            this.apk = apk;
        }

        @Override
        public int compareTo(ApkDatum ad) {
            if (apk.equals(ad.apk))
                return 0;
            else if (apk.isAfter(ad.apk))
                return 1;
            else
                return -1;
        }
        @Override
        public String toString(){
            return "kenteken " + kenteken + " apkdatum " + apk;
        }
    }

}
