package edu.jsp.one_to_one;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("bi-dir");
        EntityManager manager = factory.createEntityManager();

        // Create objects
        Address address = new Address();
        address.setArea("Area");
        address.setCity("City");
        address.setState("State");
        address.setPincode(123456);

        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setNoOfProducts(2); // Example value
       
        orderInfo.setAddress(address); // Set the address into OrderInfo

        // Set bidirectional relationship
        address.setOrderInfo(orderInfo);

        // Begin transaction and save OrderInfo (and indirectly Address due to cascade)
        manager.getTransaction().begin();
        manager.persist(orderInfo);
        manager.getTransaction().commit();

    }
}
