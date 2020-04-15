package org.academiadecodigo.rhashtafaris.threadsinapool.persistence.dao.jpa;

import org.academiadecodigo.rhashtafaris.threadsinapool.model.AbstractModel;
import org.academiadecodigo.rhashtafaris.threadsinapool.persistence.dao.CRUDDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class AbstractDao<T extends AbstractModel> implements CRUDDao<T> {

    private Class<T> modelType;

    @PersistenceContext
    protected EntityManager em;

    public AbstractDao(Class<T> modelType) {
        this.modelType = modelType;
    }

    @Override
    public List<T> findAll() {

        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<T> criteriaQuery = builder.createQuery(modelType);

        Root<T> root = criteriaQuery.from(modelType);

        criteriaQuery.select(root);

        return em.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public T findById(Integer id) {

        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<T> criteriaQuery = builder.createQuery(modelType);

        Root<T> root = criteriaQuery.from(modelType);

        criteriaQuery.where(builder.equal(root.get("id"), id));

        return em.createQuery(criteriaQuery).getSingleResult();

    }

    @Override
    public T saveOrUpdate(T model) {

        return em.merge(model);
    }

    @Override
    public void delete(T id) {

        em.remove(id);

    }


}
