package org.academiadecodigo.rhashtafaris.threadsinapool.model.impl;

import org.academiadecodigo.rhashtafaris.threadsinapool.model.AbstractModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name= "events")
public class Event extends AbstractModel {

    private String name;
    private Date date;

    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "events",
            fetch = FetchType.EAGER
    )
    private List<Ticket> tickets = new ArrayList<>();

    //getters and setters

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
