package org.academiadecodigo.rhashtafaris.threadsinapool.service;

import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Ticket;
import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.User;

import java.util.List;

public interface UserService {

    List<Ticket> listUserTickets(Integer id);

    void addTicket(Ticket ticket, User user);

    User getByName(String name);

    void matchTicket(Integer userId,Ticket ticket);

}
