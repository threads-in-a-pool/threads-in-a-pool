package org.academiadecodigo.rhashtafaris.threadsinapool.service;

import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Ticket;
import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.User;
import org.academiadecodigo.rhashtafaris.threadsinapool.serverExceptions.NotFoundEx;

import java.util.List;

public interface TicketService extends CRUDService<Ticket> {

    List<Integer> getTicketMatchUsersListByTicketId(Integer ticketId);

    void ticketTrade(Ticket ticket1, Ticket ticket2) throws NotFoundEx;
}
