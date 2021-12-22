package com.itvdn.javastarter.test.simple_dao.dao;

import com.itvdn.javastarter.test.simple_dao.entity.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientJDBCDao implements ClientDAO {
    @Override
    public void add(Client client) {
        Connection connection = null;
        connection = getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("INSERT INTO Clients(name, age, phone) values (?, ?, ?)");
            statement.setString(1, client.getName());
            statement.setInt(2, client.getAge());
            statement.setString(3, client.getPhone());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Client> getAll() {
        List<Client> clients = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement("SELECT * from clients");

            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);
                String phone = rs.getString(4);

                Client client = new Client();
                client.setId(id);
                client.setName(name);
                client.setAge(age);
                client.setPhone(phone);
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return clients;
    }

    @Override
    public Client getById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        Client client = new Client();

        try{
            connection = getConnection();
            statement = connection.prepareStatement("SELECT * from clients where id = ?");

            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                String name = rs.getString(2);
                int age = rs.getInt(3);
                String phone = rs.getString(4);

                client.setId(id);
                client.setName(name);
                client.setAge(age);
                client.setPhone(phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return client;
    }

    @Override
    public void updatePhone(String phone, int clientId) {
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = getConnection();
            statement = connection.prepareStatement("UPDATE clients set phone = ? where id = ?");

            statement.setString(1, phone);
            statement.setInt(2, clientId);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void remove(String name) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement("DELETE from clients where name = ?");

            statement.setString(1, name);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    private Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsshop", "root123", "root123");
            return connection;
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
