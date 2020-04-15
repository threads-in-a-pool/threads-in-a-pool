package org.academiadecodigo.rhashtafaris.threadsinapool.persistence.dao.jpa;

import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Ticket;
import org.academiadecodigo.rhashtafaris.threadsinapool.persistence.dao.TicketDao;

public class TicketDaoImpl extends AbstractDao <Ticket> implements TicketDao {

    public TicketDaoImpl(){
        super(Ticket.class);
    }

}
