package ru.itis.orm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class MainForHBM {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        // открываем сессию для работы с БД
        Session session = sessionFactory.openSession();
        // открываем транзакцию (выполняется либо полностью, либо не выполняется)
        Transaction transaction = session.beginTransaction();
        // создали пользователя
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
        // сохраянем его в БД
        session.persist(user1);
        session.persist(user2);
        // завершили транзакцию
        transaction.commit();

        // открываем новую транзакцию
        transaction = session.beginTransaction();
        // создаем машину
        Car camry = Car.builder()
                .model("Camry")
                .build();
        Car landRover = Car.builder()
                .model("Land Rover")
                .build();
        Car granta = Car.builder()
                .model("Гранта")
                .build();

        Car priora = Car.builder()
                .model("Приора")
                .build();
        // добавляем машину пользователю
        user1.getCars().add(camry);
        user1.getCars().add(landRover);

        user2.getCars().add(priora);
        user2.getCars().add(granta);
        // сохраняем машины
        session.persist(camry);
        session.persist(landRover);
        session.persist(priora);
        session.persist(granta);
        // сохраняем пользователей
        session.persist(user1);
        session.persist(user2);
        // завершаем транзакцию
        transaction.commit();
//        // создаем запрос на получение пользователя по его ID
//        Query<User> userQuery = session.createQuery("from User where id = :id")
//                .setParameter("id", 1L);
//        // получаем результат выполнения запроса
//        User marsel = userQuery.getSingleResult();
//        // выводим машины этого человека
//        System.out.println(marsel.getCars().toString());

        Query<User> usersQuery = session.createQuery("from User");
        List<User> users = usersQuery.getResultList();

        System.out.println(users);
        session.close();
    }
}
