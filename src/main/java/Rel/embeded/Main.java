package Rel.embeded;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


//Use @Embeddable for small, reusable data types.
//✅ Use @Embedded in the owning entity to store its fields in the same table.
//✅ If you need a relationship between two entities, use @OneToOne, @OneToMany, or @ManyToOne, not embedding.


//Embedded types share the table of the owning entity.
//They cannot have relationships (like @OneToMany) inside them. If you need relationships, you’d typically model those with @Entity and proper relationships (@OneToMany, @ManyToOne, etc.).
//        Embedded types don’t have their own identity or primary key.


//// Employee Embedding Relationship with Laptop table.
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
        emp2.setLaptop(laptop2);

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