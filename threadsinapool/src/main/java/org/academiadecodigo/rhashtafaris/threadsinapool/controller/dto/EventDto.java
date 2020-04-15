package org.academiadecodigo.rhashtafaris.threadsinapool.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class EventDto {


    @NotNull
    @NotBlank
    @Size(min = 3, max = 65)
    private String name;

    @NotNull
    @NotBlank
    private Date date;
    git 
    private String imageUrl;
}
