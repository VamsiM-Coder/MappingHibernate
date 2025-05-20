package org.onetomany2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main21 {
    public static void main(String[] args) {
        Laptop21 laptop1 = new Laptop21();
        laptop1.setLid(1);
        laptop1.setLname("Dell");
        laptop1.setModel("Inspiron");

        Laptop21 laptop2 = new Laptop21();
        laptop2.setLid(2);
        laptop2.setLname("HP");
        laptop2.setModel("Pavilion");

        Employee21 emp = new Employee21();
        emp.setEmpId(1001);
        emp.setEmpName("John Doe");
        emp.setEmpSalary(80000.0);
        emp.setDepartment("Development");

        // Set relationships
        laptop1.setEmployee(emp);
        laptop2.setEmployee(emp);
        emp.setLaps(Arrays.asList(laptop1, laptop2));

        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(Employee21.class)
                .addAnnotatedClass(Laptop21.class)
                .buildSessionFactory();

        Session session = sf.openSession();
        Transaction txn = session.beginTransaction();

        session.persist(emp);  // cascade will persist laptops

        txn.commit();
        session.close();
        sf.close();
    }
}

