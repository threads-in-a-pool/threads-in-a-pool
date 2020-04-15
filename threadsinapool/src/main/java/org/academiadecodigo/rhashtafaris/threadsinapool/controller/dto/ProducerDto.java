package org.academiadecodigo.rhashtafaris.threadsinapool.controller.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProducerDto {

    @NotNull
    @NotBlank
    @Size(min = 3, max = 65)
    private String producerName;

    @NotNull
    @NotBlank
    @Size(min = 6, max = 64)
    private String password;

    @Email
    private String email;

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
