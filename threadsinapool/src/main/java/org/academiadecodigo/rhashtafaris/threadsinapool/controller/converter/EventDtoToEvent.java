package org.academiadecodigo.rhashtafaris.threadsinapool.controller.converter;

import org.academiadecodigo.rhashtafaris.threadsinapool.controller.dto.EventDto;
import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Event;
import org.springframework.stereotype.Component;

@Component
public class EventDtoToEvent extends AbstractConverter<EventDto, Event> {

    @Override
    public Event convert(EventDto eventDto) {

        Event event = new Event();

        event.setId(eventDto.getId());
        event.setName(eventDto.getName());
        event.setDate(eventDto.getDate());
        event.setImageUrl(eventDto.getImageUrl());

        return event;
    }
}
