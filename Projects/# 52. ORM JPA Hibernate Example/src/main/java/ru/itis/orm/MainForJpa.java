package ru.itis.orm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class MainForJpa {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user1 = User.builder()
                .age(25)
                .firstName("Марсель")
                .lastName("Сидиков")
                .cars(new ArrayList<Car>())
                .build();

        User user2 = User.builder()
                .age(23)
                .firstName("Олег")
                .lastName("Игонин")
                .cars(new ArrayList<Car>())
                .build();
        session.persist(user1);
        session.persist(user2);
        transaction.commit();

        transaction = session.beginTransaction();
        Car camry = Car.builder()
                .model("Camry")
                .owner(user1)
                .build();
        Car landRover = Car.builder()
                .model("Land Rover")
                .owner(user1)
                .build();
        Car granta = Car.builder()
                .model("Гранта")
                .owner(user2)
                .build();

        Car priora = Car.builder()
                .model("Приора")
                .owner(user2)
                .build();
        session.persist(camry);
        session.persist(landRover);
        session.persist(priora);
        session.persist(granta);

        session.clear();
        transaction.commit();

        Query<User> usersQuery = session.createQuery("from User");
        List<User> users = usersQuery.getResultList();

        System.out.println(users);
        session.close();
    }
}
