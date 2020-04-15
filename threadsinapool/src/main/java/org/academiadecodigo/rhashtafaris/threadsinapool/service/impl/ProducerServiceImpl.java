package org.academiadecodigo.rhashtafaris.threadsinapool.service.impl;

import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Event;
import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Producer;
import org.academiadecodigo.rhashtafaris.threadsinapool.persistence.dao.EventDao;
import org.academiadecodigo.rhashtafaris.threadsinapool.persistence.dao.ProducerDao;
import org.academiadecodigo.rhashtafaris.threadsinapool.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerServiceImpl extends AbstractService<Producer> implements ProducerService {

    private ProducerDao producerDao;
    private EventDao eventDao;

    @Autowired
    public ProducerServiceImpl(ProducerDao dao, EventDao eventDao) {
        super(dao);
        this.producerDao = dao;
        this.eventDao = eventDao;

    }

    @Override
    public List<Event> listAllEvents() {
        return eventDao.findAll();
    }

    @Override
    public List<Event> listAllEventsFromProducer(Integer id) {
            Producer producer = dao.findById(id);

            return producer.getEvents();
    }

    @Override
    public Event saveEventOnProducer(Event event) {
        return eventDao.saveOrUpdate(event);
    }

    @Override
    public boolean eventExists(Integer id) {
        return false;
    }

    @Override
    public Producer getByName(String name) {
        return producerDao.findByUsername(name);
    }

    @Override
    public void deleteEventFromProducer(Integer producerId, Integer eventId) {

    }
}
