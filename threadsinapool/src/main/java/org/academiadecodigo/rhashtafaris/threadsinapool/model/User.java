package org.academiadecodigo.rhashtafaris.threadsinapool.model;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "users")
public class User extends AbstractModel {

    private String username;
    private String email;
    private String password;

    @OneToMany(
    cascade = {CascadeType.all},
    orphanRemoval = true,
    mappedBy = "users",
    fetch = FetchType.EAGER
    )
    private List<Ticket> tickets = new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
