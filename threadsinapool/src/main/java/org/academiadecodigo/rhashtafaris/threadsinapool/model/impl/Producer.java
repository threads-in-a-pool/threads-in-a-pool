package org.academiadecodigo.rhashtafaris.threadsinapool.model.impl;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "producers")
public class Producer extends LoginEntity{

    private String email;

    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "producer",
            fetch = FetchType.EAGER
    )
    private List<Event> events = new ArrayList<>();

    //getters and setters

    public Producer(){}


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
