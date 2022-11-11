package nl.belastingdienst.caseJohan.Controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreateApkDatumLijst {

    CreateEntityManager createEntityManager = new CreateEntityManager();
    EntityManager em = createEntityManager.getEntityManager();
    EntityTransaction tx = em.getTransaction();

    public void vrachtwagenApkLijstMaken() {
        tx.begin();
        Query query = em.createQuery("Select v.apkDatum, v.kenteken From Vrachtwagen v order by v.apkDatum asc");
        List<Object[]> apkLijst = query.getResultList();

        for (Object[] vrachtwagen1 : apkLijst) {
            LocalDate apkDatum = (LocalDate) vrachtwagen1[0];
            String kenteken = (String) vrachtwagen1[1];
            System.out.println("Kenteken " + kenteken + " heeft apk datum " + apkDatum + ".");
        }


        tx.commit();
    }

    public void chassisApkLijstMaken(){
        tx.begin();
        Query query = em.createQuery("Select c.apkDatum, c.kenteken From Chassis c order by c.apkDatum asc");
        List<Object[]> apkLijst = query.getResultList();

        for (Object[] chassis : apkLijst) {
            LocalDate apkDatum = (LocalDate) chassis[0];
            String kenteken = (String) chassis[1];
            System.out.println("Chassis met kenteken " + kenteken + " heeft apk datum " + apkDatum + ".");
        }

        tx.commit();
    }

    public void VrachtwagenEnChassisAPKLijstMaken(){
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
        tx.commit();
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
