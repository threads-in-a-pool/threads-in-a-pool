package org.academiadecodigo.rhashtafaris.threadsinapool.controller.converter;

import org.academiadecodigo.rhashtafaris.threadsinapool.controller.dto.EventDto;
import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Event;
import org.springframework.stereotype.Component;

@Component
public class EventToEventDto extends AbstractConverter<Event, EventDto> {

    @Override
    public EventDto convert(Event event) {

        EventDto eventDto = new EventDto();

        eventDto.setId(event.getId());
        eventDto.setName(event.getName());
        eventDto.setDate(event.getDate());
        eventDto.setImageUrl(event.getImageUrl());

        return eventDto;
    }
}
