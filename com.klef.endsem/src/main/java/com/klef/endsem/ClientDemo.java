package com.klef.endsem;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClientDemo {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        // Insert Vehicle
        Car car = new Car();
        car.setName("Sedan");
        car.setType("Car");
        car.setMaxSpeed(200);
        car.setColor("Red");
        car.setNumberOfDoors(4);
        session.save(car);

        Truck truck = new Truck();
        truck.setName("Freightliner");
        truck.setType("Truck");
        truck.setMaxSpeed(120);
        truck.setColor("Blue");
        truck.setLoadCapacity(5000);
        session.save(truck);

        transaction.commit();
        session.close();

        System.out.println("Data saved successfully!");
    }
}
