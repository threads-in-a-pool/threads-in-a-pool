package org.academiadecodigo.rhashtafaris.threadsinapool.model.impl;

import org.academiadecodigo.rhashtafaris.threadsinapool.model.AbstractModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tickets")
public class Ticket extends AbstractModel {

    private Date eventDate;
    private Integer userId;

    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "tickets",
            fetch = FetchType.EAGER
    )
    private List<User> machedUsers = new ArrayList<>();

    //getters and setters

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public List<User> getMachedUsers() {
        return machedUsers;
    }

    public void setMachedUsers(List<User> machedUsers) {
        this.machedUsers = machedUsers;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
