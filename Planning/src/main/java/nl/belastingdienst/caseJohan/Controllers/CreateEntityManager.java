package nl.belastingdienst.caseJohan.Controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateEntityManager {

    public EntityManager getEntityManager() {
        String persistenceUnitName = "jpa-hiber-postgres-pu";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        EntityManager em = emf.createEntityManager();
        return em;
    }
}
