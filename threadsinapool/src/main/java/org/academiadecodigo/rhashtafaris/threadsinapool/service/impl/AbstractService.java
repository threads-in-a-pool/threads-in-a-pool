package org.academiadecodigo.rhashtafaris.threadsinapool.service.impl;

import org.academiadecodigo.rhashtafaris.threadsinapool.model.AbstractModel;
import org.academiadecodigo.rhashtafaris.threadsinapool.persistence.dao.CRUDDao;
import org.academiadecodigo.rhashtafaris.threadsinapool.service.CRUDService;

import java.util.List;


public abstract class AbstractService<T extends AbstractModel> implements CRUDService<T> {

    protected CRUDDao<T> dao;


    public AbstractService(CRUDDao<T> dao) {
        this.dao = dao;
    }

    @Override
    public List<T> listAll() {
        return null;
    }

    @Override
    public void save(T model) {

    }

    @Override
    public void delete(T model) {

    }

    @Override
    public T getById(Integer id) {
        return null;
    }

    @Override
    public T getByName(String name) {
        return null;
    }

    @Override
    public boolean exists(Integer Id) {
        return false;
    }
}
