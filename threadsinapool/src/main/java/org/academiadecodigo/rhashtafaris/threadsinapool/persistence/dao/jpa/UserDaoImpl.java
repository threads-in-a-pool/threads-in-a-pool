package org.academiadecodigo.rhashtafaris.threadsinapool.persistence.dao.jpa;

import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Ticket;
import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.User;
import org.academiadecodigo.rhashtafaris.threadsinapool.persistence.dao.UserDao;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

@Repository
public class UserDaoImpl extends AbstractDao<User> implements UserDao {


    public UserDaoImpl() {
        super(User.class);
    }

    @Override
    public User findByUserName(String username) {

        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);

        Root<User> root = criteriaQuery.from(User.class);

        criteriaQuery.select(root);

        criteriaQuery.where(builder.equal(root.get("username"), username));

        return em.createQuery(criteriaQuery).getSingleResult();

    }
}
