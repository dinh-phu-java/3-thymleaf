package com.dinhphu.services;

import com.dinhphu.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import java.util.Date;

public class EmployeeDatabaseConnection{
    private static SessionFactory factory;

    public EmployeeDatabaseConnection(){
       factory= getSessionFactory();
    }


    public static SessionFactory getSessionFactory() {
        factory = new Configuration()
        .configure().addAnnotatedClass(Employee.class).buildSessionFactory();
        return factory;
    }

//    public static SessionFactory getFactory(){
//        return factory;
//    }


//    public static void main(String[] args) {
//        EmployeeDatabaseConnection employeeDatabaseConnection=new EmployeeDatabaseConnection();
//
//        SessionFactory factory= employeeDatabaseConnection.getSessionFactory();
//
//        try {
//            Session session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Date dob= DateUtils.parseDate("07-06-2019");
//
//            Employee tempEmployee1 = new Employee("Kante", "Golo", dob);
//            Employee tempEmployee2 = new Employee("Arnold", "Alexander", dob);
//            Employee tempEmployee3 = new Employee("Robertson", "Alex", dob);
//            Employee tempEmployee4 = new Employee("Firmino", "Roberto", dob);
//
//
//
//            session.save(tempEmployee1);
//            session.save(tempEmployee2);
//            session.save(tempEmployee3);
//            session.save(tempEmployee4);
//
//            session.getTransaction().commit();
//        }
//        finally{
//         factory.close();
//        }
//    }
}
