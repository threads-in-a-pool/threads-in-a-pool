package org.academiadecodigo.rhashtafaris.threadsinapool.model;

import java.util.ArrayList;

@Entity
@Table(name= "users")
public class User implements Model {

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


    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public void setId() {

    }
}
