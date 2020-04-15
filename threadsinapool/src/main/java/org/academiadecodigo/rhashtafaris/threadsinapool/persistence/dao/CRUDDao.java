package org.academiadecodigo.rhashtafaris.threadsinapool.persistence.dao;

import org.academiadecodigo.rhashtafaris.threadsinapool.model.AbstractModel;

import java.util.List;

public interface CRUDDao<T extends AbstractModel> {

    List<T> findAll();
    T findById(Integer Id);
    T saveOrUpdate(T model);
    void delete(T id);
}
