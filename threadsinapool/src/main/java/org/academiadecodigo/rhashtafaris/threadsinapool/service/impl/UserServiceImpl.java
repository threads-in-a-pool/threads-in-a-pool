package org.academiadecodigo.rhashtafaris.threadsinapool.service.impl;

import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Ticket;
import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.User;
import org.academiadecodigo.rhashtafaris.threadsinapool.persistence.dao.UserDao;
import org.academiadecodigo.rhashtafaris.threadsinapool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl extends AbstractService<User> implements UserService {


    @Autowired
    public UserServiceImpl(UserDao dao) {
        super(dao);
    }

    @Override
    public List<Ticket> listUserTickets(Integer id) {
        return null;
    }
}
