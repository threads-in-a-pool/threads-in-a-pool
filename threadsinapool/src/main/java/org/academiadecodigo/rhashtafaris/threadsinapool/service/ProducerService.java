package org.academiadecodigo.rhashtafaris.threadsinapool.service;

import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Event;
import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Producer;
import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Ticket;
import org.academiadecodigo.rhashtafaris.threadsinapool.serverExceptions.NotFoundEx;

import java.util.List;

public interface ProducerService {

    List<Ticket> getTicketsByEventId(Integer id) throws NotFoundEx;

    Producer getById(Integer id) throws NotFoundEx;

    Producer save(Producer producer);

    List<Producer> listProducers();

    List<Event> listAllEvents();

    List<Event> listAllEventsFromProducer(Integer id) throws NotFoundEx;

    Event saveEventOnProducer (Event event,Producer producer);

    Event getEventById(Integer id) throws NotFoundEx;

    boolean eventExists(Integer id);

    Producer getByName(String name);

    void deleteEventFromProducer(Integer producerId, Integer eventId);

}
