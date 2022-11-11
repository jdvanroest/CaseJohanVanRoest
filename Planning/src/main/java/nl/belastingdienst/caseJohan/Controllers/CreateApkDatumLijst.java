package nl.belastingdienst.caseJohan.Controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.time.LocalDate;
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
}
