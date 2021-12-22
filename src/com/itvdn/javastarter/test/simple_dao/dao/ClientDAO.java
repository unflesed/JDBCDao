package com.itvdn.javastarter.test.simple_dao.dao;

import com.itvdn.javastarter.test.simple_dao.entity.Client;

import java.util.List;

public interface ClientDAO {
    void add(Client client);

    List<Client> getAll();

    Client getById(int id);

    void updatePhone(String phone, int clientId);

    void remove(String name);
}
