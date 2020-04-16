package org.academiadecodigo.rhashtafaris.threadsinapool.service;

import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Event;
import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Producer;
import org.academiadecodigo.rhashtafaris.threadsinapool.serverExceptions.NotFoundEx;

import java.util.List;

public interface ProducerService {


    Producer getById(Integer id) throws NotFoundEx;

    List<Producer> listProducers();

    List<Event> listAllEvents();

    List<Event> listAllEventsFromProducer(Integer id) throws NotFoundEx;

    Event saveEventOnProducer (Event event);

    Event getEventById(Integer id) throws NotFoundEx;

    boolean eventExists(Integer id);

    Producer getByName(String name);

    void deleteEventFromProducer(Integer producerId, Integer eventId);

}
