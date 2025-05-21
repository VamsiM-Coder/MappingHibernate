package org.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
// If we didn't used mapped by in both the entities they both think my responsibility to mapping
// So 4 tables are created.
// By using mapped by  field we can mapp using 3 tables only.
import java.util.Arrays;

public class MainN {
    public static void main(String[] args) {
        // ----- Laptops -----
        LaptopN laptop1 = new LaptopN();
        laptop1.setLid(1);
        laptop1.setLname("Dell");
        laptop1.setModel("Inspiron");

        LaptopN laptop2 = new LaptopN();
        laptop2.setLid(2);
        laptop2.setLname("HP");
        laptop2.setModel("Pavilion");

        LaptopN laptop3 = new LaptopN();
        laptop3.setLid(3);
        laptop3.setLname("Lenovo");
        laptop3.setModel("ThinkPad");

        LaptopN laptop4 = new LaptopN();
        laptop4.setLid(4);
        laptop4.setLname("Apple");
        laptop4.setModel("MacBook Pro");

        // ----- Employees -----
        EmployeeN emp1 = new EmployeeN();
        emp1.setEmpId(101);
        emp1.setEmpName("Alice");
        emp1.setEmpSalary(75000);
        emp1.setLaptops(Arrays.asList(laptop1, laptop2));  // Alice uses Dell, HP

        EmployeeN emp2 = new EmployeeN();
        emp2.setEmpId(102);
        emp2.setEmpName("Bob");
        emp2.setEmpSalary(85000);
        emp2.setLaptops(Arrays.asList(laptop2, laptop3));  // Bob uses HP, Lenovo

        EmployeeN emp3 = new EmployeeN();
        emp3.setEmpId(103);
        emp3.setEmpName("Charlie");
        emp3.setEmpSalary(90000);
        emp3.setLaptops(Arrays.asList(laptop1, laptop3, laptop4));  // Charlie uses Dell, Lenovo, Apple

        EmployeeN emp4 = new EmployeeN();
        emp4.setEmpId(104);
        emp4.setEmpName("Diana");
        emp4.setEmpSalary(88000);
        emp4.setLaptops(Arrays.asList(laptop4));  // Diana uses only MacBook

        // ----- Set reverse mapping (optional but good practice) -----
        laptop1.setEmployees(Arrays.asList(emp1, emp3));
        laptop2.setEmployees(Arrays.asList(emp1, emp2));
        laptop3.setEmployees(Arrays.asList(emp2, emp3));
        laptop4.setEmployees(Arrays.asList(emp3, emp4));

        // ----- Hibernate Configuration -----
        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(EmployeeN.class)
                .addAnnotatedClass(LaptopN.class)
                .buildSessionFactory();

        Session session = sf.openSession();
        Transaction txn = session.beginTransaction();

        // ----- Persist Employees (cascade will persist laptops too) -----
        session.persist(emp1);
        session.persist(emp2);
        session.persist(emp3);
        session.persist(emp4);



        txn.commit();


        session.close();
        sf.close();

    }
}
