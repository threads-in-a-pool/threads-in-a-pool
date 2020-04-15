package org.academiadecodigo.rhashtafaris.threadsinapool.service;

import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Ticket;
import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.User;

import java.util.List;

public interface TicketService extends CRUDService<Ticket> {

    List<User> getTicketMatchUsersListByTicketId(Integer ticketId);
}
