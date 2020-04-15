package org.academiadecodigo.rhashtafaris.threadsinapool.persistence.dao.jpa;

import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Event;
import org.academiadecodigo.rhashtafaris.threadsinapool.persistence.dao.EventDao;

public class EventDaoImpl extends AbstractDao<Event> implements EventDao {

    public EventDaoImpl() {
        super(Event.class);
    }
}
