package org.academiadecodigo.rhashtafaris.threadsinapool.model.impl;

import org.academiadecodigo.rhashtafaris.threadsinapool.model.AbstractModel;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tickets")
public class Ticket extends AbstractModel {

    private Date eventDate;
    private Event event;

    //getters and setters

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
