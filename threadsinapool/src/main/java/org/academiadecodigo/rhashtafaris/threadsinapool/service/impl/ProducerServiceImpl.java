package org.academiadecodigo.rhashtafaris.threadsinapool.service.impl;

import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Event;
import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Producer;
import org.academiadecodigo.rhashtafaris.threadsinapool.persistence.dao.ProducerDao;
import org.academiadecodigo.rhashtafaris.threadsinapool.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerServiceImpl extends AbstractService<Producer> implements ProducerService {


    @Autowired
    public ProducerServiceImpl(ProducerDao dao) {
        super(dao);
    }

    @Override
    public List<Event> listAllEvents() {
        return null;
    }

    @Override
    public List<Event> listAllEventsFromProducer(Integer id) {
        return null;
    }

    @Override
    public Event saveEventOnProducer(Event event) {
        return null;
    }

    @Override
    public boolean eventExists(Integer id) {
        return false;
    }

    @Override
    public void deleteEventFromProducer(Integer producerId, Integer eventId) {

    }
}
