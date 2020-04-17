package org.academiadecodigo.rhashtafaris.threadsinapool.controller.converter;

import org.academiadecodigo.rhashtafaris.threadsinapool.controller.dto.TicketDto;
import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Ticket;
import org.springframework.stereotype.Component;

@Component
public class TicketToTicketDto extends AbstractConverter<Ticket, TicketDto> {

    @Override
    public TicketDto convert(Ticket ticket) {

        TicketDto ticketDto = new TicketDto();

        ticketDto.setId(ticket.getId());
        ticketDto.setUser(ticket.getUser().getId());
        ticketDto.setEvent(ticket.getEvent().getId());

        return ticketDto;
    }
}
