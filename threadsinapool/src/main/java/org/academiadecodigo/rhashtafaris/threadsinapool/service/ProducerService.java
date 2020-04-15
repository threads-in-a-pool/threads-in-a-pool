package org.academiadecodigo.rhashtafaris.threadsinapool.service;

import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Event;
import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Producer;

import java.util.List;

public interface ProducerService {

<<<<<<< Updated upstream
=======
    Producer getProducerById(Integer id);

    Producer getProducerByProducerName (String producerName);

    List<Producer> listAllProducers();

    List<Event> listAllEvents();

>>>>>>> Stashed changes
    List<Event> listAllEventsFromProducer(Integer id);

    Event saveEventOnProducer (Event event);

    boolean eventExists(Integer id);

    void deleteEventFromProducer(Integer producerId, Integer eventId);


}
