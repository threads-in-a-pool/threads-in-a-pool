package org.academiadecodigo.rhashtafaris.threadsinapool.service;

import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Event;
import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Producer;

import java.util.List;

public interface ProducerService {

    Producer getProducerById(Integer id);

    Producer getProducerByProducerName (String producerName);

    List<Producer> listAllProducers();

    List<Event>

    List<Event> listAllEventsFromProducer(Integer id);

    Producer saveProducer(Producer producer);

    Event saveEventOnProducer (Event event);

    boolean producerExists(String producerName);

    boolean eventExists(Integer id);

    void deleteProducer(Integer id);

    void deleteEventFromProducer(Integer producerId, Integer eventId);


}
