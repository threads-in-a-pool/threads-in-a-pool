package org.academiadecodigo.rhashtafaris.threadsinapool.persistence.dao.jpa;

import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Producer;
import org.academiadecodigo.rhashtafaris.threadsinapool.persistence.dao.ProducerDao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class ProducerDaoImpl extends AbstractDao<Producer> implements ProducerDao {

    public ProducerDaoImpl() {
        super(Producer.class);
    }

    @Override
    public Producer findByUsername(String username) {

        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<Producer> criteriaQuery = builder.createQuery(Producer.class);

        Root<Producer> root = criteriaQuery.from(Producer.class);

        criteriaQuery.select(root);

        criteriaQuery.where(builder.equal(root.get("username"), username));

        return em.createQuery(criteriaQuery).getSingleResult();
    }
}
