package eagerlazyfetch;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setBrand("Asus");
        l1.setModel("Rog");
        l1.setRam(16);


        Laptop l2 = new Laptop();
        l2.setLid(2);
        l2.setBrand("Dell");
        l2.setModel("XPS");
        l2.setRam(32);

        Laptop l3 = new Laptop();
        l3.setLid(3);
        l3.setBrand("Apple");
        l3.setModel("Macbook air");
        l3.setRam(8);

        Alien a1 = new Alien();
        a1.setAid(101);
        a1.setAname("Navin");
        a1.setTech("Java");


        Alien a2 = new Alien();
        a2.setAid(102);
        a2.setAname("Harsh");
        a2.setTech("Python");


        a1.setLaptops(Arrays.asList(l1, l2));
        a2.setLaptops(Arrays.asList(l3));


        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(eagerlazyfetch.Alien.class)
                .addAnnotatedClass(Laptop.class)
                .buildSessionFactory();

        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();
        session.persist(l1);
        session.persist(l2);
        session.persist(l3);

        session.persist(a1);
        session.persist(a2);

        transaction.commit();


        session.close();

        Session session1 = sf.openSession();

        Alien a5 = session1.get(Alien.class, 101);
        System.out.println(a5);
        session1.close();
        sf.close();
        // In the same session we insert and get the data hibernate uses caching concept
        // It directly retrieve info from session not interact with DB
        // If some changes happen then we retrieve data ,problem may come to avoid this get the data in different session.

        // Lazy Fetching and Eager Fetching
        // Lazy fetching get data only Alien entity not Laptop entity doesn't join the tables
        // If we want it we want to explicitly print the result then lazy fetch write a query with join Laptop entity with Alien.
        // Defaultly hibernate fetch data type Lazy.
        //@OneToMany
        //private List<Laptop> laptops;

        // Eager Fetching is useful while retreiving the query we want the get full query with alien and laptop we go for this fetching
        //  we explicitly mention this in ALien entity oneToMany Annotation by (fetch = FetchType.Eager)
        //  @OneToMany(fetch = FetchType.EAGER)
        //    private List<Laptop> laptops;

    }

}