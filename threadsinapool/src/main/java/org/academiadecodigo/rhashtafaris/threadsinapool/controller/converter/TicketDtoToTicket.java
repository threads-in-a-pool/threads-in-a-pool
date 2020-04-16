package org.academiadecodigo.rhashtafaris.threadsinapool.controller.converter;

import org.academiadecodigo.rhashtafaris.threadsinapool.controller.dto.TicketDto;
import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Ticket;
import org.springframework.stereotype.Component;

@Component
public class TicketDtoToTicket extends AbstractConverter<TicketDto, Ticket> {

    @Override
    public Ticket convert(TicketDto ticketDto) {

        Ticket ticket = new Ticket();

        ticket.setId(ticketDto.getId());
        ticket.setUserId(ticketDto.getUserId());
        ticket.setEventId(ticketDto.getEventId());

        return ticket;
    }
}
