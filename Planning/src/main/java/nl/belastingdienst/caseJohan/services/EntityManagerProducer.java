package nl.belastingdienst.caseJohan.services;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.*;
import javax.transaction.TransactionScoped;

public class EntityManagerProducer {
    @Inject
    transient EntityManagerFactory emf;

    @Produces
    public EntityManager create() {
        return emf.createEntityManager();
    }

    public void close(@Disposes EntityManager em) {
        if (em.isOpen()) {
            em.close();
        }
    }



}
