package org.academiadecodigo.rhashtafaris.threadsinapool.service;

import org.academiadecodigo.rhashtafaris.threadsinapool.serverExceptions.NotFoundEx;

import java.util.List;

public interface CRUDService<T> {

    List<T> listAll();

    T save(T model);

    void delete(T model);

    T getById(Integer id) throws NotFoundEx;

    boolean exists(Integer Id);
    
}
