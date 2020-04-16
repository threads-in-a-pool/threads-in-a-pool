package org.academiadecodigo.rhashtafaris.threadsinapool.model.impl;

import org.academiadecodigo.rhashtafaris.threadsinapool.model.AbstractModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tickets")
public class Ticket extends AbstractModel {

    @ManyToOne
    private Event event;

    @ManyToOne
    private User user;

    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "tickets",
            fetch = FetchType.EAGER
    )
    private List<User> machedUsers = new ArrayList<>();

    //getters and setters

    public List<User> getMachedUsers() {
        return machedUsers;
    }

    public void setMachedUsers(List<User> machedUsers) {
        this.machedUsers = machedUsers;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
