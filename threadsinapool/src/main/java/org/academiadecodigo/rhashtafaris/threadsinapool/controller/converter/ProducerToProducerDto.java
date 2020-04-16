package org.academiadecodigo.rhashtafaris.threadsinapool.controller.converter;

import org.academiadecodigo.rhashtafaris.threadsinapool.controller.dto.ProducerDto;
import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Producer;
import org.springframework.stereotype.Component;

@Component
public class ProducerToProducerDto extends AbstractConverter<Producer, ProducerDto> {

    @Override
    public ProducerDto convert(Producer producer) {

        ProducerDto producerDto = new ProducerDto();

        producerDto.setId(producer.getId());
        producerDto.setUsername(producer.getUsername());
        producerDto.setEmail(producer.getEmail());
        producerDto.setPassword(producer.getPassword());

        return producerDto;
    }
}
