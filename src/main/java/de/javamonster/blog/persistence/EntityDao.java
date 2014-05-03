package de.javamonster.blog.persistence;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Abstract implementation of the entity DAO.
 *
 * @author Tim Brueckner
 */
public class EntityDao {

    @Inject
    @DataRepository
    private EntityManager entityManager;

    public <T> T edit(T object) {
        return entityManager.merge(object);
    }

    public void create(Object object) {
        entityManager.persist(object);
    }

    public void refresh(Object object) {
        entityManager.refresh(object);
    }

    public <T> T find(Class<T> clazz, Long id) {
        return entityManager.find(clazz, id);
    }

    public <T> List<T> findAll(Class<T> clazz) {
        final CriteriaQuery<T> cq = this.entityManager.getCriteriaBuilder().createQuery(clazz);
        cq.select(cq.from(clazz));
        final List<T> resultList = getEntityManager().createQuery(cq).getResultList();

        return resultList;
    }

    public <T> int count(Class<T> clazz) {
        final CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        final Root<T> rootNode = cq.from(clazz);
        final Expression<Long> count = cb.count(rootNode);
        cq.select(count);
        final Long size = this.entityManager.createQuery(cq).getSingleResult();
        return size.intValue();
    }

    public void remove(Object object) {
        entityManager.remove(getEntityManager().merge(object));
    }

    public EntityManager getEntityManager() {
        return this.entityManager;
    }
}

