package org.academiadecodigo.rhashtafaris.threadsinapool.controller.converter;

import org.academiadecodigo.rhashtafaris.threadsinapool.controller.dto.ProducerDto;
import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Producer;

public class ProducerDtoToProducer extends AbstractConverter<ProducerDto, Producer> {

    @Override
    public Producer convert(ProducerDto producerDto) {

        Producer producer = new Producer();

        producer.setId(producerDto.getId());
        producer.setProducerName(producerDto.getProducerName());
        producer.setEmail(producerDto.getEmail());
        producer.setPassword(producerDto.getPassword());

        return producer;
    }
}
