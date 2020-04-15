package org.academiadecodigo.rhashtafaris.threadsinapool.service;

import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Ticket;
import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.User;

import java.util.List;

public interface UserService {

    User getUserById(Integer id);

    User getUserByUsername(String username);

    User save(User user);

    boolean userExists(String username);

    void deleteUser(Integer id);

    List<User> listAllUsers();

    List<Ticket> listUserTickets(Integer id);
}
