package org.academiadecodigo.rhashtafaris.threadsinapool.controller.converter;

import org.academiadecodigo.rhashtafaris.threadsinapool.controller.dto.TicketDto;
import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Ticket;
import org.academiadecodigo.rhashtafaris.threadsinapool.persistence.dao.EventDao;
import org.academiadecodigo.rhashtafaris.threadsinapool.persistence.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicketDtoToTicket extends AbstractConverter<TicketDto, Ticket> {

    @Autowired
    private UserDao userDao;
    @Autowired
    private EventDao eventDao;

    @Override
    public Ticket convert(TicketDto ticketDto) {

        Ticket ticket = new Ticket();

        ticket.setId(ticketDto.getId());
        ticket.setUser(userDao.findById(ticketDto.getUser()));
        ticket.setEvent(eventDao.findById(ticketDto.getEvent()));

        return ticket;
    }
}
