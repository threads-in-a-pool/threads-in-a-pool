package org.academiadecodigo.rhashtafaris.threadsinapool.controller.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProducerDto {

    private Integer id;

    @NotNull(message = "Name should have 3 or more characters.")
    @NotBlank(message = "Name should have 3 or more characters.")
    @Size(min = 3, max = 65, message = "Name should have 3 or more characters.")
    private String producerName;

    @NotNull(message = "Password should have at least 6characters.")
    @NotBlank(message = "Password should have at least 6characters.")
    @Size(min = 6, max = 64, message = "Password should have at least 6 characters.")
    private String password;

    @Email(message = "E-mail should be valid.")
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
