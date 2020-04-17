package org.academiadecodigo.rhashtafaris.threadsinapool.controller.dto;


public class TicketDto {


    private Integer id;
    private Integer user_id;
    private Integer event_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUser() {
        return user_id;
    }

    public void setUser(int user) {
        this.user_id = user;
    }

    public int getEvent() {
        return event_id;
    }

    public void setEvent(int event) {
        this.event_id = event;
    }
}
