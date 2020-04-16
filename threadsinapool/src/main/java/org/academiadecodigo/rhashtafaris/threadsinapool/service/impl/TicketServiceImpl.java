package org.academiadecodigo.rhashtafaris.threadsinapool.service.impl;

import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Ticket;
import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.User;
import org.academiadecodigo.rhashtafaris.threadsinapool.persistence.dao.TicketDao;
import org.academiadecodigo.rhashtafaris.threadsinapool.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TicketServiceImpl extends AbstractService<Ticket> implements TicketService {


    @Autowired
    public TicketServiceImpl(TicketDao dao) {
        super(dao);
    }

    @Transactional
    @Override
    public List<Integer> getTicketMatchUsersListByTicketId(Integer ticketId) {

        Ticket ticket = dao.findById(ticketId);

        return ticket.getMachedUserIds();
    }
}
