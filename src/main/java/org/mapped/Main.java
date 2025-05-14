package org.mapped;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {

        Employee emp1 = new Employee();
        emp1.setEmpId(1);
        emp1.setEmpName("Mary");
        emp1.setEmpSalary(75000.54);
        emp1.setDepartment("Software Testing");

        Employee emp2 = new Employee();
        emp2.setEmpId(2);
        emp2.setEmpName("John");
        emp2.setEmpSalary(64000.57);
        emp2.setDepartment("Business Executive");

        Laptop laptop1 = new Laptop();
        laptop1.setLid(1);
        laptop1.setLname("Lenovo");
        laptop1.setModel("Computer Science");

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Employee.class)
                .configure().
                buildSessionFactory();

        Session session = sf.openSession();

        Transaction txn = session.beginTransaction();

        session.persist(emp1);
        session.persist(emp2);

        txn.commit();

        sf.close();
        session.close();
    }
}