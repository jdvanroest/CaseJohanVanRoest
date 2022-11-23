package nl.belastingdienst.caseJohan.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.*;
import javax.transaction.TransactionScoped;

@RequestScoped
public class EntityManagerProduces {
    @PersistenceUnit
    private javax.persistence.EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-hiber-postgres-pu");

    @Produces
    @RequestScoped
    public EntityManager create(){return emf.createEntityManager();}

    public void close(@Disposes EntityManager em) {
        if (em.isOpen()) {
            em.close();
        }
    }



}
