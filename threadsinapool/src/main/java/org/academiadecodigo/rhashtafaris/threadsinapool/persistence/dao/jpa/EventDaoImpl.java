package org.academiadecodigo.rhashtafaris.threadsinapool.persistence.dao.jpa;

import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Event;
import org.academiadecodigo.rhashtafaris.threadsinapool.persistence.dao.EventDao;
import org.springframework.stereotype.Repository;

@Repository
public class EventDaoImpl extends AbstractDao<Event> implements EventDao {

    public EventDaoImpl() {
        super(Event.class);
    }
}
