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



