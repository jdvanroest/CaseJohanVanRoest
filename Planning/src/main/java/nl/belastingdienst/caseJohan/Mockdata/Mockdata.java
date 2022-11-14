package nl.belastingdienst.caseJohan.Mockdata;

import nl.belastingdienst.caseJohan.Controllers.CreateEntityManager;

import javax.persistence.EntityManager;

import javax.persistence.EntityTransaction;

public class Mockdata {

    CreateEntityManager createEntityManager = new CreateEntityManager();
    public void mockdataInvoeren() {
        EntityManager em = createEntityManager.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        tx.commit();
    }

}
