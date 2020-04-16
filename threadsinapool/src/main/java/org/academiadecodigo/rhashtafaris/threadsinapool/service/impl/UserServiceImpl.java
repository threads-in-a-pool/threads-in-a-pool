package org.academiadecodigo.rhashtafaris.threadsinapool.service.impl;

import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Ticket;
import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.User;
import org.academiadecodigo.rhashtafaris.threadsinapool.persistence.dao.TicketDao;
import org.academiadecodigo.rhashtafaris.threadsinapool.persistence.dao.UserDao;
import org.academiadecodigo.rhashtafaris.threadsinapool.serverExceptions.UserNotFoundEx;
import org.academiadecodigo.rhashtafaris.threadsinapool.service.TicketService;
import org.academiadecodigo.rhashtafaris.threadsinapool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserServiceImpl extends AbstractService<User> implements UserService {

    private TicketDao ticketDao;
    private UserDao userDao;

    @Autowired
    private TicketService ticketService;

    @Autowired
    public UserServiceImpl(UserDao userDao, TicketDao ticketDao) {
        super(userDao);
        this.ticketDao = ticketDao;
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public List<Ticket> listUserTickets(Integer id) {
        return ticketDao.findAll();
    }

    @Transactional
    @Override
    public void addTicket(Ticket ticket, User user) {
        ticket.setUser(user);
        ticketDao.saveOrUpdate(ticket);
    }

    @Transactional
    @Override
    public User getByName(String name) throws UserNotFoundEx {
        User user = userDao.findByUserName(name);

        if (user == null){
            throw new UserNotFoundEx();
        }

        return user;
    }

    @Transactional
    @Override
    public User getById(Integer id) throws UserNotFoundEx {
        User user = userDao.findById(id);

        if (user == null){
            throw new UserNotFoundEx();
        }

        return user;
    }

    @Transactional
    @Override
    public void matchTicket(Integer matchUserId, Ticket ticket) {

        List<Integer> matchedTicketUsers = ticket.getMachedUserIds();

        matchedTicketUsers.add(matchUserId);

    }
}
