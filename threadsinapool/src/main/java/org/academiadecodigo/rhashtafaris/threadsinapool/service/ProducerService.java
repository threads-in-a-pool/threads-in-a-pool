package org.academiadecodigo.rhashtafaris.threadsinapool.service;

import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Event;
import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Producer;

import java.util.List;

public interface ProducerService {


    List<Event> listAllEvents();

    List<Event> listAllEventsFromProducer(Integer id);

    Event saveEventOnProducer (Event event);

    boolean eventExists(Integer id);

    void deleteEventFromProducer(Integer producerId, Integer eventId);


}
