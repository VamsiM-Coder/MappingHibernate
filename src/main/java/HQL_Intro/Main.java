package HQL_Intro;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;


// HQL = > Hibernate Query Language
// It is object oriented PL used in hibernate to perform db operations(CRUD) using entity objects instead of direct SQL tables
// It is not a native SQL -> hql queries are Independent irrespective of MySQL,Oracle,MongoDB,PostGreSQL.`
// Cleanable and more readable for object readable mapping.
// It supports joins,aggregation and subqueries like SQL
// It can't supports advanced SQL like CTE'S and Indexes.
// It is less efficient than optimized native SQL

public class Main {
    public static void main(String[] args) {

        Laptop l1 = new Laptop();
        l1.setLid(4);
        l1.setBrand("Asus");
        l1.setModel("Vivobook");
        l1.setRam(16);


        Laptop l2 = new Laptop();
        l2.setLid(5);
        l2.setBrand("HP");
        l2.setModel("Pavilion");
        l2.setRam(32);

        Laptop l3 = new Laptop();
        l3.setLid(6);
        l3.setBrand("HP");
        l3.setModel("Omen");
        l3.setRam(8);




        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(Laptop.class)
                .buildSessionFactory();

        Session session = sf.openSession();

        // Fetching all entities
        Query<Laptop> query = session.createQuery("from HQL_Intro.Laptop");
        List<Laptop> laps = query.getResultList();
        System.out.println(laps);

        // Fetching entities by conditions
        Query<Laptop> query2 = session.createQuery("from HQL_Intro.Laptop WHERE ram = 8");
        List<Laptop> laps2 = query2.getResultList();
        System.out.println(laps2);

        //Agregation
        Query<Laptop> query3 = session.createQuery("select count(*) from HQL_Intro.Laptop");
        List<Laptop> laps3 = query3.getResultList();
        System.out.println(laps3);

        session.close();
        sf.close();

    }
}
