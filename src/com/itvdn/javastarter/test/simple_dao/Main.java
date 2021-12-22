package com.itvdn.javastarter.test.simple_dao;

import com.itvdn.javastarter.test.simple_dao.dao.CarDAO;
import com.itvdn.javastarter.test.simple_dao.dao.ClientDAO;
import com.itvdn.javastarter.test.simple_dao.dao.DAOFactory;
import com.itvdn.javastarter.test.simple_dao.dao.IDAOFactory;
import com.itvdn.javastarter.test.simple_dao.entity.Car;
import com.itvdn.javastarter.test.simple_dao.entity.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 31.01.2018.
 */
public class Main {

    public static void main(String[] args) {
        IDAOFactory factory = DAOFactory.getInstance();
        CarDAO carDAO = factory.getCarDAO();
        ClientDAO clientDAO = factory.getClientDAO();

// ============== add(Car car) ============

        Car car1 = new Car();
        car1.setMark("Audi");
        car1.setModel("A8");
        car1.setPrice(15_000);

        carDAO.add(car1);


//        Car car2 = new Car();
//        car2.setMark("Chevrolet");
//        car2.setModel("E2");
//        car2.setPrice(45_000);
//
//        carDAO.add(car2);


// =========== getAll() ============

//        List<Car> cars = carDAO.getAll();
//        for (Car car : cars) {
//            System.out.println(car);
//        }
//

// =========== getById(int id)  ============

//        Car car3 = carDAO.getById(2);
//        System.out.println(car3);


// ===========  updatePrice(int price, int carId) ============

//        carDAO.updatePrice(100_000, 1);

// ===========  remove(String mark) ============
//        carDAO.remove("chevrolet");

        //-------------------add new Client
        Client client = new Client();
        client.setName("Ivan");
        client.setAge(22);
        client.setPhone("+3333333");

        //clientDAO.add(client);

        //-------------------getAllClients
        List<Client> clients = clientDAO.getAll();
        for (Client cl: clients){
            System.out.println(cl);
        }

        //-------------------getById
        System.out.println("-=getById=-");
        System.out.println(clientDAO.getById(4));

        //-------------------updatePhone
        clientDAO.updatePhone("+123456", 2);

        //-------------------remove
        clientDAO.remove("Ivan");

    }

}
