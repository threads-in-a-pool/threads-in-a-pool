package org.academiadecodigo.rhashtafaris.threadsinapool.controller.dto;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class EventDto {

    private Integer id;

    @NotNull(message = "Name should have 3 or more characters.")
    @NotBlank(message = "Name should have 3 or more characters.")
    @Size(min = 3, max = 65, message = "Name should have 3 or more characters.")
    private String name;

    @NotNull(message = "You have to put a valid date.")
    @NotBlank(message = "You have to put a valid date.")
    @Future(message = "You can only put events that will happen.")
    private Date date;

    @NotNull(message = "Should contain an image URL.")
    @NotBlank(message = "Should contain an image URL.")
    private String imageUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
