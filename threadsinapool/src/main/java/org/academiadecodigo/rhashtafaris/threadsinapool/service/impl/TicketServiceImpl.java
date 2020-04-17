package org.academiadecodigo.rhashtafaris.threadsinapool.service.impl;

import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Ticket;
import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.User;
import org.academiadecodigo.rhashtafaris.threadsinapool.persistence.dao.TicketDao;
import org.academiadecodigo.rhashtafaris.threadsinapool.serverExceptions.NotFoundEx;
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

    @Transactional
    @Override
    public void ticketTrade(Ticket ticket1, Ticket ticket2) throws NotFoundEx {

        User user1 = ticket1.getUser();
        User user2 = ticket2.getUser();
        
        if (user1 == null || user2 == null){
            throw new NotFoundEx();
        }

        ticket1.setUser(user2);
        ticket1.getMachedUserIds().remove(user2.getId());

        ticket2.setUser(user1);
        ticket2.getMachedUserIds().remove(user1.getId());

        dao.saveOrUpdate(ticket1);
        dao.saveOrUpdate(ticket2);

    }
}
