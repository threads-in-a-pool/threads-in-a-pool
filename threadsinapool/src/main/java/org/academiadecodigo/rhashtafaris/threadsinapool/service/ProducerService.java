package org.academiadecodigo.rhashtafaris.threadsinapool.service;

import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Event;
import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Producer;

import java.util.List;

public interface ProducerService {

    Producer getProducerById(Integer id);

    Producer getProducerByProducerName (String producerName);

    List<Producer> listAllProducers();

    List<Event> listAllEventsFromProducer(Integer id);

    Producer save(Producer producer);

    boolean producerExists(String producerName);

    void deleteProducer(Integer id);

}
