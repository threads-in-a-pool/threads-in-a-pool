package org.academiadecodigo.rhashtafaris.threadsinapool.service;

import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Ticket;
import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.User;
import org.academiadecodigo.rhashtafaris.threadsinapool.serverExceptions.UserNotFoundEx;

import java.util.List;

public interface UserService extends CRUDService<User>{

    List<Ticket> listUserTickets(Integer id);

    void addTicket(Ticket ticket, User user);

    User getByName(String name) throws UserNotFoundEx;

    User getById(Integer id) throws UserNotFoundEx;

    void matchTicket(Integer userId,Ticket ticket);

}
