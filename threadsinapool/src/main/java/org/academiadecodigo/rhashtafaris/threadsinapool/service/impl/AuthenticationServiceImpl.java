package org.academiadecodigo.rhashtafaris.threadsinapool.service.impl;

import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.Producer;
import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.User;
import org.academiadecodigo.rhashtafaris.threadsinapool.persistence.dao.ProducerDao;
import org.academiadecodigo.rhashtafaris.threadsinapool.persistence.dao.UserDao;
import org.academiadecodigo.rhashtafaris.threadsinapool.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private UserDao userDao;
    private ProducerDao producerDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setProducerDao(ProducerDao producerDao) {
        this.producerDao = producerDao;
    }

    @Override
    public boolean authenticateUser(String username, String password) {

        User user = userDao.findByUserName(username);

        if (user == null){
            return false;
        }
        return user.getPassword() == password;
    }

    @Override
    public boolean authenticateProducer(String producerName, String password) {

        Producer producer = producerDao.findByUsername(producerName);

        if (producer == null){
            return false;
        }
        return producer.getPassword() == password;
    }

}
