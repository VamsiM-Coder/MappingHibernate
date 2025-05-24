package Rel.onetoone;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main1 {
    public static void main(String[] args) {

        Laptop1 l1 = new Laptop1();
        l1.setLid(1);
        l1.setLname("Lenovo");
        l1.setModel("ThinkPad");

        Laptop1 l2 = new Laptop1();
        l2.setLid(2);
        l2.setLname("HP");
        l2.setModel("Pavilion");

        Employee1 emp1 = new Employee1();
        emp1.setEmpId(1);
        emp1.setEmpName("Mary");
        emp1.setEmpSalary(75000.54);
        emp1.setDepartment("Software Testing");
        emp1.setLaptop(l1);  // 👈 Establish OneToOne

        Employee1 emp2 = new Employee1();
        emp2.setEmpId(2);
        emp2.setEmpName("Jashwanth");
        emp2.setEmpSalary(43464.5);
        emp2.setDepartment("ML Engineer");
        emp2.setLaptop(l2);  // 👈 Establish OneToOne

        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(Employee1.class)
                .addAnnotatedClass(Laptop1.class)
                .buildSessionFactory();

        Session session = sf.openSession();
        Transaction txn = session.beginTransaction();


        session.persist(emp1);
        session.persist(emp2);
        //We can use this method manually otherwise
        //session.persist(l1);
        //session.persist(l2);

        //we can use this Employee class
        //@OneToOne(cascade = CascadeType.ALL)
        //private Laptop1 lap;

        txn.commit();
        session.close();
        sf.close();
    }
}
