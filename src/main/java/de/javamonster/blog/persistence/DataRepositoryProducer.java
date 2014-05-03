package de.javamonster.blog.persistence;

import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Produces instances of the entity manager.
 *
 * @author Tim Brueckner
 */
@Stateless
public class DataRepositoryProducer {

    private EntityManager entityManager;

    @Produces
    @DataRepository
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext(unitName = "FlyWayUnit")
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}