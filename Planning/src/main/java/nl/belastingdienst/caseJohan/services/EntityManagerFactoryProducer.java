package nl.belastingdienst.caseJohan.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

public class EntityManagerFactoryProducer {

    @Produces
    @ApplicationScoped
    @PersistenceUnit
    public EntityManagerFactory create() {
        return Persistence.createEntityManagerFactory("jpa-hiber-postgres-pu");
    }

    public void destroy(@Disposes EntityManagerFactory factory) {
        factory.close();
    }
}
