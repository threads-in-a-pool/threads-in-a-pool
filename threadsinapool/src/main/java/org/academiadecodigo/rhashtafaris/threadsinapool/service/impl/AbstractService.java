package org.academiadecodigo.rhashtafaris.threadsinapool.service.impl;

import org.academiadecodigo.rhashtafaris.threadsinapool.model.AbstractModel;
import org.academiadecodigo.rhashtafaris.threadsinapool.persistence.dao.CRUDDao;
import org.academiadecodigo.rhashtafaris.threadsinapool.serverExceptions.UserNotFoundEx;
import org.academiadecodigo.rhashtafaris.threadsinapool.service.CRUDService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public abstract class AbstractService<T extends AbstractModel> implements CRUDService<T> {

    protected CRUDDao<T> dao;


    public AbstractService(CRUDDao<T> dao) {
        this.dao = dao;
    }

    @Transactional
    @Override
    public List<T> listAll() {
        return dao.findAll();
    }

    @Transactional
    @Override
    public void save(T model) {
        dao.saveOrUpdate(model);
    }

    @Transactional
    @Override
    public void delete(T model) {
        dao.delete(model);
    }

    @Transactional
    @Override
    public T getById(Integer id) throws UserNotFoundEx {
        return dao.findById(id);
    }

    @Override
    public boolean exists(Integer Id) {
        return false;
    }
}
