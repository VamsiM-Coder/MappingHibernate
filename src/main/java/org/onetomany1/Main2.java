package org.onetomany1;
// It results 3 tables one laptop,employee and laptop_employee

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
public class Main2{
public static void main(String[] args) {
        Laptop2 laptop1 = new Laptop2();
        laptop1.setLid(1);
        laptop1.setLname("Dell");
        laptop1.setModel("Inspiron");

        Laptop2 laptop2 = new Laptop2();
        laptop2.setLid(2);
        laptop2.setLname("HP");
        laptop2.setModel("Pavilion");

        Employee2 emp = new Employee2();
        emp.setEmpId(1001);
        emp.setEmpName("John Doe");
        emp.setEmpSalary(80000.0);
        emp.setDepartment("Development");

        // Set relationships
        laptop1.setEmployee2(emp);
        laptop2.setEmployee2(emp);
        emp.setLaps(Arrays.asList(laptop1, laptop2));

        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(Employee2.class)
                .addAnnotatedClass(Laptop2.class)
                .buildSessionFactory();

        Session session = sf.openSession();
        Transaction txn = session.beginTransaction();


        session.persist(emp);
        //We can use this method manually otherwise
        //session.persist(l1);

        //we can use this Employee class
        //@OneToMany(cascade = CascadeType.ALL)
        //private List<Laptop2> lap;

        txn.commit();
        session.close();
        sf.close();
    }
}
