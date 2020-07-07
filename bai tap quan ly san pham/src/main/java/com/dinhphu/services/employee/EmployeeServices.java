package com.dinhphu.services.employee;

import com.dinhphu.model.Employee;
import com.dinhphu.services.DateUtils;
import com.dinhphu.services.EmployeeDatabaseConnection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeServices implements IEmployeeServices{


    public EmployeeServices(){

    }

    @Override
    public List<Employee> findAll() {
       SessionFactory factory = new Configuration()
                .configure().addAnnotatedClass(Employee.class).buildSessionFactory();
        ArrayList<Employee> list =null;

        Session session=factory.getCurrentSession();

        session.beginTransaction();

        list=new ArrayList<>(session.createQuery("from Employee").getResultList()) ;

        session.getTransaction().commit();

        factory.close();
        return list;
    }

    @Override
    public Employee findById(int id) {
        Employee employee=null;
        SessionFactory factory = new Configuration()
                .configure().addAnnotatedClass(Employee.class).buildSessionFactory();
        Session session=factory.getCurrentSession();


        session.beginTransaction();

        employee= session.get(Employee.class,id);

        session.getTransaction().commit();

        factory.close();
        return employee;
    }

    @Override
    public Employee save(Employee model) {
        SessionFactory factory = new Configuration()
                .configure().addAnnotatedClass(Employee.class).buildSessionFactory();
        Session session=factory.getCurrentSession();

        session.beginTransaction();

        session.save(model);

        session.getTransaction().commit();
        factory.close();
        return null;
    }

    @Override
    public void remove(int id) {
        SessionFactory factory = new Configuration()
                .configure().addAnnotatedClass(Employee.class).buildSessionFactory();
        Session session=factory.getCurrentSession();

        session.beginTransaction();

        Employee deleteEmp=session.get(Employee.class,id);

        session.delete(deleteEmp);

        session.getTransaction().commit();
        factory.close();
    }

    @Override
    public void update(Employee model) {
        SessionFactory factory = new Configuration()
                .configure().addAnnotatedClass(Employee.class).buildSessionFactory();
        Session session=factory.getCurrentSession();

        session.beginTransaction();
        Employee editEmp=findById(model.getId());

        session.createQuery("update Employee set firstName="+model.getFirstName()+", lastName="+model.getLastName()+" where id="+model.getId()).executeUpdate();

        session.getTransaction().commit();
        factory.close();
    }

//    public static void main(String[] args) {
//        EmployeeServices employeeServices=new EmployeeServices();
//        Employee editEmp=employeeServices.findById(1);
////        editEmp.setFirstName("test Update");
////        System.out.println(editEmp);
//
//        Session session=new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory().getCurrentSession();
//
//        session.beginTransaction();
//
//        String date="12-24-2019";
//        Date dob=DateUtils.parseDate(date);
//        System.out.println(editEmp.getId());
////        System.out.println(dob.toString());
//        session.createQuery("update Employee set firstName='Test Update 5', lastName='Test 2' where id="+editEmp.getId()).executeUpdate();
//
//        session.getTransaction().commit();
//        factory.close();
//
//
//    }
}
