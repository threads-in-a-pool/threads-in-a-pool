package org.academiadecodigo.rhashtafaris.threadsinapool.service.impl;

import org.academiadecodigo.rhashtafaris.threadsinapool.model.AbstractModel;
import org.academiadecodigo.rhashtafaris.threadsinapool.persistence.dao.CRUDDao;

import java.util.List;

public abstract class AbstractService<T extends AbstractModel> implements CRUDDao<T> {

    protected CRUDDao<T> dao;

    public AbstractService(CRUDDao<T> dao) {
        this.dao = dao;
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public T findById(Integer Id) {
        return null;
    }

    @Override
    public T saveOrUpdate(T model) {
        return null;
    }

    @Override
    public void delete(T id) {

    }

}
