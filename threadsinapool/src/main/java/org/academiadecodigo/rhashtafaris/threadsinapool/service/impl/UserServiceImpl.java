package org.academiadecodigo.rhashtafaris.threadsinapool.service.impl;

import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Ticket;
import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.User;
import org.academiadecodigo.rhashtafaris.threadsinapool.persistence.dao.TicketDao;
import org.academiadecodigo.rhashtafaris.threadsinapool.persistence.dao.UserDao;
import org.academiadecodigo.rhashtafaris.threadsinapool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserServiceImpl extends AbstractService<User> implements UserService {

    private TicketDao ticketDao;

    @Autowired
    public UserServiceImpl(UserDao userDao, TicketDao ticketDao) {
        super(userDao);
        this.ticketDao = ticketDao;
    }

    @Transactional
    @Override
    public List<Ticket> listUserTickets(Integer id) {
        return ticketDao.findAll();
    }

    @Transactional
    @Override
    public void addTicket(Ticket ticket, User user) {
        ticket.setUserId(user.getId());
        ticketDao.saveOrUpdate(ticket);
    }

    @Override
    public void matchTicket(User user, Ticket ticket) {



    }
}
