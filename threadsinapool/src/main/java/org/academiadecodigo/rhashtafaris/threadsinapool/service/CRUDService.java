package org.academiadecodigo.rhashtafaris.threadsinapool.service;

import java.util.List;

public interface CRUDService<T> {

    List<T> listAll();

    void save(T model);

    void delete(T model);

    T getById(Integer id);

    T getByName(String name);

    boolean exists(Integer Id);
    
}
