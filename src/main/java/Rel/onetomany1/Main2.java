package Rel.onetomany1;
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

        Laptop2 laptop3 = new Laptop2();
        laptop3.setLid(3);
        laptop3.setLname("ASUS");
        laptop3.setModel("NoteBook");

        Employee2 emp = new Employee2();
        emp.setEmpId(1001);
        emp.setEmpName("John Doe");
        emp.setEmpSalary(80000.0);
        emp.setDepartment("Development");

        Employee2 emp2 = new Employee2();
        emp2.setEmpId(1002);
        emp2.setEmpName("Jashwanth");
        emp2.setEmpSalary(45000.644);
        emp2.setDepartment("Testing");


        // Set relationships
        laptop1.setEmployee2(emp);
        laptop2.setEmployee2(emp);

        laptop3.setEmployee2(emp2);
        emp.setLaps(Arrays.asList(laptop1, laptop3));
        emp2.setLaps(Arrays.asList(laptop2));

        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(Employee2.class)
                .addAnnotatedClass(Laptop2.class)
                .buildSessionFactory();

        Session session = sf.openSession();
        Transaction txn = session.beginTransaction();


        session.persist(emp);
        session.persist(emp2);
        //We can use this method manually otherwise
        session.persist(laptop1);
        session.persist(laptop2);
        session.persist(laptop3);

        //we can use this Employee class
        //@OneToMany(cascade = CascadeType.ALL)
        //private List<Laptop2> lap;

        txn.commit();
        //emp4 = session.get(Employee2.class, 1001);

        session.close();

        Session session2 = sf.openSession();

//        Employee2 emp4 = session2.get(Employee2.class, 1001);
//        System.out.println(emp4);

        session2.close();
        sf.close();
    }
}
