package org.academiadecodigo.rhashtafaris.threadsinapool.controller.dto;

public class TicketDto {


    private Integer id;
    private Integer userId;
    private Integer eventId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
