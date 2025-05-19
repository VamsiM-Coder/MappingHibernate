package org.mapped;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

// Employee Embedding Relationship with Laptop table.
public class Main {
    public static void main(String[] args) {
        Laptop laptop1 = new Laptop();
        laptop1.setLid(1);
        laptop1.setLname("Lenovo");
        laptop1.setModel("ThinkPad");

        Laptop laptop2 = new Laptop();
        laptop2.setLid(2);
        laptop2.setLname("Asus");
        laptop2.setModel("VivoBook");

        Employee emp1 = new Employee();
        emp1.setEmpId(1);
        emp1.setEmpName("Arya Stark");
        emp1.setEmpSalary(75000.54);
        emp1.setDepartment("Software Testing");
        emp1.setLaptop(laptop1);

        Employee emp2 = new Employee();
        emp2.setEmpId(2);
        emp2.setEmpName("John Snow");
        emp2.setEmpSalary(64000.57);
        emp2.setDepartment("Business Executive");


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