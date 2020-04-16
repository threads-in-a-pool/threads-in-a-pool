package org.academiadecodigo.rhashtafaris.threadsinapool.service;

import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Ticket;
import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.User;
import org.academiadecodigo.rhashtafaris.threadsinapool.serverExceptions.NotFoundEx;

import java.util.List;

public interface UserService extends CRUDService<User>{

    List<Ticket> listUserTickets(Integer id);

    boolean userExists(Integer id);

    Ticket addTicket(Ticket ticket, User user);

    User getByName(String name) throws NotFoundEx;

    User getById(Integer id) throws NotFoundEx;

    void matchTicket(Integer userId,Ticket ticket);

}
