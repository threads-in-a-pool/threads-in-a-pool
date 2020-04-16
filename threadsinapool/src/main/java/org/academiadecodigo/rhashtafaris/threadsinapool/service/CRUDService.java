package org.academiadecodigo.rhashtafaris.threadsinapool.service;

import org.academiadecodigo.rhashtafaris.threadsinapool.serverExceptions.UserNotFoundEx;

import java.util.List;

public interface CRUDService<T> {

    List<T> listAll();

    void save(T model);

    void delete(T model);

    T getById(Integer id) throws UserNotFoundEx;

    boolean exists(Integer Id);
    
}
