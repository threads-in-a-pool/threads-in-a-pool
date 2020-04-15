package org.academiadecodigo.rhashtafaris.threadsinapool.persistence.dao;

import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Producer;

public interface ProducerDao extends CRUDDao<Producer> {

    Producer findByUsername(String username);
}
