Vehicle class:

package com.klef.jfsd.exam;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String type;
    private int maxSpeed;
    private String color;

    
}

car subclass

package com.klef.jfsd.exam;

import jakarta.persistence.Entity;

@Entity
public class Car extends Vehicle {
    private int numberOfDoors;

    
}

truck sub class

package com.klef.jfsd.exam;

import jakarta.persistence.Entity;

@Entity
public class Truck extends Vehicle {
    private int loadCapacity;
}

Hibernate utility class
package com.klef.jfsd.exam;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

Demo class

package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClientDemo {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

         Insert Vehicle
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




