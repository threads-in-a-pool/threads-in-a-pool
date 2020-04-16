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

    @ElementCollection
    private List<Integer> machedUserIds = new ArrayList<>();

    //getters and setters

    public Ticket(){}
/*
    public List<User> getMachedUsers() {
        return machedUsers;
    }

    public void setMachedUsers(List<User> machedUsers) {
        this.machedUsers = machedUsers;
    }
*/
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

    public List<Integer> getMachedUserIds() {
        return machedUserIds;
    }

    public void setMachedUserIds(List<Integer> machedUserIds) {
        this.machedUserIds = machedUserIds;
    }
}
