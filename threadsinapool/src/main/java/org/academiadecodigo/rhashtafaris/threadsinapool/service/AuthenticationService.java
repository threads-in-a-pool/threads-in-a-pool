package org.academiadecodigo.rhashtafaris.threadsinapool.service;

public interface AuthenticationService {

    boolean authenticateUser(String username, String password);
    boolean authenticateProducer(String producerName, String password);
}
